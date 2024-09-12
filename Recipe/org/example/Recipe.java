package Recipe.org.example;

import java.text.DecimalFormat;
import java.util.*;

public class Recipe {
    private String name;
    private HashMap<Ingredient, Double> ingredientList;
    private double numberOfItemsCreated;
    private HashMap<Recipe, Double> subRecipe;

    public Recipe(String name, double numberOfItemsCreated, Ingredient... _ingredients) {
        this.name = name;
        this.ingredientList = new HashMap<>();
        this.subRecipe = new HashMap<>();
        this.numberOfItemsCreated = numberOfItemsCreated;
        for (Ingredient i : _ingredients) {
            ingredientList.put(i, numberOfItemsCreated);
        }
    }

//    public String getName() {
//        return name;
//    }
//
    public Map<Recipe, Double> getSubRecipe() {
        return subRecipe;
    }

    public boolean addSubRecipe(Recipe recipe, double quantity) {
        if (quantity <= 0) {
            throw new NegativeNumException("Quantity cannot be negative");
        }
        subRecipe.put(recipe, quantity);
        return true;
    }

    public boolean addIngredientsToRecipe(Ingredient ingredient, double quantity) {
        Objects.requireNonNull(ingredient);
        if (quantity < 0){
                throw new NegativeNumException("Quantity cannot be negative");
        }
        ingredientList.put(ingredient, quantity);
        return true;
    }

    public Map<String, Double> getIngredientsAndQuantityInRecipe() {
        Map<String, Double> newMap = new HashMap<>();
        for (Map.Entry<Ingredient, Double> item : ingredientList.entrySet()) {
            newMap.put(item.getKey().getName(), item.getValue());
        }
        return newMap;
    }

    public Map<Ingredient, Double> getAllIngredientsInRecipe() {
        return ingredientList;
    }

//    public Map<Ingredient, Double> getAllSubRecipe() {
//        Map<Ingredient, Double> subRecipeList = new HashMap<>();
//        for (Map.Entry<Recipe, Double> r : recipe.entrySet()) {
//            subRecipeList = sub.getKey().getAllIngredientsInRecipe();
//        }
//        return subRecipeIngredientList;
//    }

    public int getSizeOfMap() {
        return ingredientList.size();
    }

    public double getQuantityOfIngredients(String name) {
        for (Map.Entry<Ingredient, Double> item : ingredientList.entrySet()) {
            if (item.getKey().getName().equals(name)) {
                return item.getValue();
            }
        }
        return 0;
    }

    public double getNumberOfItemsCreated() {
        return this.numberOfItemsCreated;
    }

    public Map<Ingredient, Double> calcAmountOfIngredientsToPurchaseOnce() {
        Map<Ingredient, Double> purchaseList = new HashMap<>();
        for (Map.Entry<Ingredient, Double> item : ingredientList.entrySet()) {
            purchaseList.put(item.getKey(), item.getValue());
        }
        for (Map.Entry<Recipe, Double> subRecipe : subRecipe.entrySet()) {
            Map<Ingredient, Double> subRecipeRequirements = subRecipe.getKey().calcAmountOfIngredientsToPurchaseOnce();
            for (Map.Entry<Ingredient, Double> subEntry : subRecipeRequirements.entrySet()) {
                purchaseList.merge(subEntry.getKey(), subEntry.getValue(), Double::sum);
            }
        }
        return purchaseList;
    }

    public Map<Ingredient, Double> calcAmountOfIngredientsToPurchase(int recipeNumber) {
        Map<Ingredient, Double> purchaseList = new HashMap<>();
        for (Map.Entry<Ingredient, Double> item : ingredientList.entrySet()) {
            purchaseList.put(item.getKey(), item.getValue() * recipeNumber);
        }
        for (Map.Entry<Recipe, Double> subRecipe : subRecipe.entrySet()) {
            Map<Ingredient, Double> subRecipeRequirements = subRecipe.getKey().calcAmountOfIngredientsToPurchase((int)(recipeNumber * subRecipe.getValue()));
            for (Map.Entry<Ingredient, Double> subEntry : subRecipeRequirements.entrySet()) {
                purchaseList.merge(subEntry.getKey(), subEntry.getValue(), Double::sum);
            }
        }
        return purchaseList;
    }

    public double calcCostPerItem() {
        double cost = 0;
        double profitMargin = 0.5;

        Map<Ingredient, Double> purchaseList = calcAmountOfIngredientsToPurchase(1);
        for (Map.Entry<Ingredient, Double> item : purchaseList.entrySet()) {
            double packsToBuy = Math.ceil(item.getValue() / item.getKey().getQuantity());
            double totalPurchased = item.getKey().getQuantity() * packsToBuy;
            double leftOver = totalPurchased % item.getValue();
            cost += item.getKey().getPrice() * packsToBuy;
        }

        DecimalFormat df = new DecimalFormat("#.##");
        double pricePerItem =  cost / numberOfItemsCreated;
        double price = pricePerItem + (pricePerItem * profitMargin);
        price = Double.parseDouble(df.format(price));
        return price;
    }

//    @Override
//    public String toString() {
//        return "name = " + name + '\'' +
//                ", ingredientList=" + ingredientList +
//                ", subRecipe=" + subRecipe +
//                '}';
//    }
}

