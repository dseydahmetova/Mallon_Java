package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BakeryTest {
    Bakery bakery;
    Recipe cookieRecipe, icing, cakeRecipe, cream;
    Ingredient milk, vanilla, sugar, eggs, butter, oil, salt, flour;

    @BeforeEach
    public void initialRecipe() {
        bakery = new Bakery();

        sugar = new Ingredient("Sugar", 4.50, 1, Unit.kg, "SupplierA");
        eggs = new Ingredient("Eggs", 3.50, 6, Unit.L, "SupplierE");
        butter = new Ingredient("Butter", 4.50, 6, Unit.oz, "SupplierA");
        oil = new Ingredient("Oil", 14.50, 1.5, Unit.l, "SupplierA");
        flour = new Ingredient("Flour", 6.25, 2, Unit.kg, "SupplierA");
        salt = new Ingredient("Salt", 2.75, 150, Unit.g, "SupplierA");
        milk = new Ingredient("Milk", 1.75, 1, Unit.l, "Supplier B");
        vanilla = new Ingredient("Vanilla", 12.0, 1, Unit.l, "Supplier C");

        // Initialized Recipes with values
        cookieRecipe = new Recipe("Cookie", 12, sugar, eggs, butter, oil, salt, flour);
        cakeRecipe = new Recipe("Cake", 1, sugar, eggs, butter, oil, salt, flour);
        cream = new Recipe("Cake", 1, sugar, eggs);


        // Adding ingredients to CookieRecipe - 6 ingredients + 2 ingredients from icing
        cookieRecipe.addIngredientsToRecipe(sugar, 0.5);
        cookieRecipe.addIngredientsToRecipe(eggs, 10);
        cookieRecipe.addIngredientsToRecipe(butter, 3.5);
        cookieRecipe.addIngredientsToRecipe(oil, 0.25);
        cookieRecipe.addIngredientsToRecipe(flour, 0.5);
        cookieRecipe.addIngredientsToRecipe(salt, 10);

        // Adding ingredients to CakeRecipe
        cakeRecipe.addIngredientsToRecipe(sugar, 0.4);
        cakeRecipe.addIngredientsToRecipe(eggs, 6);
        cakeRecipe.addIngredientsToRecipe(butter, 3.5);
        cakeRecipe.addIngredientsToRecipe(oil, 0.5);
        cakeRecipe.addIngredientsToRecipe(flour, 1);
        cakeRecipe.addIngredientsToRecipe(salt, 20);

        // Adding ingredients to cream
        cream.addIngredientsToRecipe(sugar, 1);
        cream.addIngredientsToRecipe(eggs, 16);

        //Adding sub recipe Icing
        icing = new Recipe("Icing", 1);
        icing.addIngredientsToRecipe(sugar, 0.5);
        icing.addIngredientsToRecipe(milk, 1);
        icing.addIngredientsToRecipe(vanilla, 1);

        // Create main recipe (Cookie with icing)
        cookieRecipe.addSubRecipe(cream, 1);
        cakeRecipe.addSubRecipe(icing, 2);

        // Add recipes to the list
        bakery.addRecipe(cookieRecipe);
        bakery.addRecipe(cakeRecipe);

        // Add ingredients to the list
        bakery.addIngredient(sugar);
        bakery.addIngredient(milk);
        bakery.addIngredient(vanilla);

        // Add ingredients to the pantry (available)
        bakery.addAvailableIngredients(sugar, 5);
        bakery.addAvailableIngredients(milk, 5);
        bakery.addAvailableIngredients(flour, 4);
        bakery.addAvailableIngredients(eggs, 20);
        bakery.addAvailableIngredients(oil, 2);
        bakery.addAvailableIngredients(butter, 16);
        bakery.addAvailableIngredients(salt, 150);
        bakery.addAvailableIngredients(vanilla, 15);

    }

    /*---------------------------------------------Ingredients---------------------------------------------------*/

    @Test
    public void testAddIngredient() {
        Ingredient newIngredient = new Ingredient("Milk", 1.50, 1, Unit.L, "SupplierB");
        bakery.addIngredient(newIngredient);
        assertTrue(bakery.getAllIngredients().iterator().hasNext(), "True if Ingredient is added successfully");
        assertThrows(NullPointerException.class, () -> bakery.addIngredient(null));
    }

    @Test
    public void testAddIngredientWithNullValue() {
        assertThrows(NullPointerException.class, () -> bakery.addIngredient(null));
    }

    @Test
    public void testAddAvailableIngredients() {
        assertTrue(bakery.addAvailableIngredients(sugar, 5));
    }

    @Test
    public void testAddAvailableIngredientsNullValue() {
        assertThrows(NullPointerException.class, () -> bakery.addAvailableIngredients(null, 5));
    }

    @Test
    public void testGetAvailableIngredients() {
        assertTrue(bakery.getAvailableIngredients().containsKey(sugar));
    }

    @Test
    public void testUpdateIngredientPrice() throws Exception {
        bakery.updateIngredientPrice("Sugar", 5);
        assertEquals(5, sugar.getPrice());
    }

    @Test
    public void testUpdateIngredientPriceNotExist() throws ItemNotFoundException {
        assertThrows(ItemNotFoundException.class, () -> bakery.updateIngredientPrice("", 5));
    }

    @Test
    public void testUpdateIngredientPriceWithNegativeNum() throws Exception {
        assertThrows(Exception.class, () -> bakery.updateIngredientPrice("Sugar", -7));
    }

    // ------------------------------------------Recipe----------------------------------------------------//
    @Test
    void testAddRecipe() {
        assertTrue(bakery.addRecipe(cookieRecipe), "True if Ingredient is added successfully");
        assertThrows(NullPointerException.class, () -> bakery.addRecipe(null));
    }

    // --------------------------------- Required Ingredients Per Batch -----------------------------------//
    @Test
    void testCalculateRequiredIngredientsForBatch() {
        double requiredQuantity = 0;
        Map<Ingredient, Double> requiredIngredients = bakery.calculateRequiredIngredientsForBatch(bakery.getRecipes());
        for (Map.Entry<Ingredient, Double> ingredient : requiredIngredients.entrySet()) {
            if (ingredient.getKey().getName().equals(sugar.getName())) {
                requiredQuantity = ingredient.getValue();
            }
        }
        assertEquals(2.4, requiredQuantity);
    }

    @Test
    void testCalcCostPerItem() {
        assertEquals(6.81, cookieRecipe.calcCostPerItem());
        assertEquals(102.0, cakeRecipe.calcCostPerItem());
    }

    @Test
    void testCalcCostPerBatch() {
        assertEquals(80.75, bakery.calcCostPerBatch(bakery.getRecipes()));
    }

    @Test
    void testCalcSubMenuQuantityForBatch() {
        Map<Recipe, Double> subRecipeList = bakery.calcSubMenuQuantityForBatch(bakery.getRecipes());
        assertTrue(subRecipeList.containsKey(icing));
        assertEquals(1.0, subRecipeList.get(cream));
    }

//    @Test
//    public void testCheckingIngredientAvailability() {
//        Ingredient falseIngredient = new Ingredient("Passion Fruit", 1.0, 1.0, Unit.kg, "SupplierD");
//        bakery.addIngredient(falseIngredient);
//        Recipe newRecipe = new Recipe("cakeRecipe", 1, sugar, eggs, falseIngredient);
//        newRecipe.addIngredientsToRecipe(sugar,20);
//        assertFalse(bakery.isIngredientFound());
//    }

    @Test
    public void testCheckAvailableIngredientsForRecipes() {
        assertTrue(bakery.checkAvailableIngredientsForRecipes(bakery.getRecipes()).contains(cakeRecipe));
        assertFalse(bakery.checkAvailableIngredientsForRecipes(bakery.getRecipes()).contains(cookieRecipe));
    }
}