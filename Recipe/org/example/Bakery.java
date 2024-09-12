package Recipe.org.example;

import java.text.DecimalFormat;
import java.util.*;

public class Bakery {
    private final List<Ingredient> ingredients;
    private final List<Recipe> recipes;
    private Map<Ingredient, Double> requiredIngredients;
    private Map<Ingredient, Double> availableIngredients;

    public Bakery() {
        this.requiredIngredients = new HashMap<>();
        this.availableIngredients = new HashMap<>();
        this.ingredients = new ArrayList<>();
        this.recipes = new ArrayList<>();
    }

    //*----------------------------------Ingredients-------------------------------------------//

    public void addIngredient(Ingredient ingredient) {
        Objects.requireNonNull(ingredient);
        ingredients.add(ingredient);
    }

    public boolean addAvailableIngredients(Ingredient ingredient, double quantity) {
        Objects.requireNonNull(ingredient);
        availableIngredients.put(ingredient, quantity);
        return true;
    }

    public Map<Ingredient, Double> getAvailableIngredients() {
        return availableIngredients;
    }

//    public Ingredient getIngredientByName(String name) {
//        for (Ingredient item : ingredients)
//            if (item.getName().equals(name)) {
//                return item;
//            }
//        return null;
//    }

    public Iterable<Ingredient> getAllIngredients() {
        return this.ingredients;
    }


    public void updateIngredientPrice(String name, double newPrice) throws ItemNotFoundException {
        boolean ingredientIsFound = false; //? Tracking Ingredient availability

        for (Ingredient item : ingredients)
            if (item.getName().equals(name)) {
                item.setPrice(newPrice);
                //* US4 : allows us to look for the ingredient, find it and update the price
                ingredientIsFound = true;
                break;
            }
        // TODO: throw a custom exception
        if (!ingredientIsFound) {
            throw new ItemNotFoundException();
        }
    }
//*------------------------------------Recipe-----------------------------------------------------//

    public boolean addRecipe(Recipe recipe) {
        Objects.requireNonNull(recipe);
        recipes.add(recipe);
        return true;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    //*------------------------------Batches------------------------------------------------------//


    //    public Map<Ingredient, Double> getRequiredIngredientsForProducts(List<Recipe> recipes) {
    // setup a map of Ingredient, Double
    // for each recipe get the list of ingredients
    //   for each ingredient
    //    add it to the map -> if it's already in there add to the quantity
    // return the map
//}
    public Map<Ingredient, Double> calculateRequiredIngredientsForBatch(List<Recipe> recipes) {
        Map<Ingredient, Double> quantityOfIngredients = new HashMap<>();

        for (Recipe recipe : recipes) {
            quantityOfIngredients = recipe.calcAmountOfIngredientsToPurchaseOnce();

            for (Map.Entry<Ingredient, Double> ingredientEntry : quantityOfIngredients.entrySet()) {
                Ingredient ingredient = ingredientEntry.getKey();
                double ingredientQuantity = ingredientEntry.getValue();
                requiredIngredients.put(ingredient, requiredIngredients.getOrDefault(ingredient, 0.0) + ingredientQuantity);
            }
        }
        return requiredIngredients;
    }

    public double calcCostPerBatch(List<Recipe> recipes) {
        double cost = 0;
        Map<Ingredient, Double> purchaseList = calculateRequiredIngredientsForBatch(recipes);
        for (Map.Entry<Ingredient, Double> item : purchaseList.entrySet()) {
            double packsToBuy = Math.ceil(item.getValue() / item.getKey().getQuantity());
            double totalPurchased = item.getKey().getQuantity() * packsToBuy;
            double leftOver = totalPurchased % item.getValue();
            cost += item.getKey().getPrice() * packsToBuy;
        }
        DecimalFormat df = new DecimalFormat("#.###");
        cost = Double.parseDouble(df.format(cost));
        return cost;
    }

    public Map<Recipe, Double> calcSubMenuQuantityForBatch(List<Recipe> recipes) {
        Map<Recipe, Double> listOfSubRecipe = new HashMap<>();
        Map<Recipe, Double> quantityOfSubRecipe = new HashMap<>();

        for (Recipe recipe : recipes) {
            quantityOfSubRecipe = recipe.getSubRecipe();

            for (Map.Entry<Recipe, Double> entry : quantityOfSubRecipe.entrySet()) {
                Recipe subRecipe = entry.getKey();
                double subRecipeQuantity = entry.getValue();
                listOfSubRecipe.put(subRecipe, listOfSubRecipe.getOrDefault(subRecipe, 0.0) + subRecipeQuantity);
            }
        }
        return listOfSubRecipe;
    }

    // ---------------------------------------------------- US4 : Checking for ingredient Availability --------------------------
//    public boolean isIngredientFound() {
//        for (Recipe recipe : recipes) {
//            for (Ingredient ingredient : recipe.getAllIngredientsInRecipe().keySet()) {
//                if (!ingredients.contains(ingredient)) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }


    // Method to check if all ingredients for a recipe are available

    public List<Recipe> checkAvailableIngredientsForRecipes(List<Recipe> recipes) {
        List<Recipe> recipesCanMake = new ArrayList<>();
        Map<Ingredient, Double> ingredientsOfRecipe = new HashMap<>();

        for (Recipe recipe : recipes) {
            List<Ingredient> unAvailableIngredient = new ArrayList<>();
            ingredientsOfRecipe = recipe.calcAmountOfIngredientsToPurchaseOnce();
            Map<Ingredient, Double> requiredAmountOfIngredients = new HashMap<>();
            for (Map.Entry<Ingredient, Double> ingredientEntry : ingredientsOfRecipe.entrySet()) {
                Ingredient ingredient = ingredientEntry.getKey();
                double ingredientQuantity = ingredientEntry.getValue();
                var availableIngredientQuantity = availableIngredients.get(ingredient);
                if (availableIngredientQuantity == null) {
                    unAvailableIngredient.add(ingredientEntry.getKey());
                    break;
                } else {
                    double quantityDifference = availableIngredientQuantity - ingredientQuantity;
                    if (quantityDifference >= 0) {
                        requiredAmountOfIngredients.put(ingredient, quantityDifference);
                    } else {
                        unAvailableIngredient.add(ingredientEntry.getKey());
                        break;
                    }
                }
            }
            if (unAvailableIngredient.isEmpty()) {
                availableIngredients.putAll(requiredAmountOfIngredients);
                recipesCanMake.add(recipe);
            }
        }
        return recipesCanMake;
    }
}

