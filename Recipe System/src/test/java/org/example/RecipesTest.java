package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RecipesTest {
    Recipe cookieRecipe, icing, cakeRecipe;
    Ingredient milk, vanilla, sugar, eggs, butter, oil, salt, flour, singleEgg;

    @BeforeEach
    public void initialRecipe() {
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


        // Adding ingredients to CookieRecipe
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

        //Adding sub recipe Icing
        icing = new Recipe("Icing", 1);
        icing.addIngredientsToRecipe(sugar, 0.5);
        icing.addIngredientsToRecipe(milk, 1);
        icing.addIngredientsToRecipe(vanilla, 1);

        // Create main recipe (Cookie with icing)
        cookieRecipe.addSubRecipe(icing, 1);
    }

    @Test
    public void testAddIngredientsToRecipe() {
        assertEquals("Eggs", eggs.getName());
        assertEquals(6, cookieRecipe.getSizeOfMap());
        assertTrue(cookieRecipe.addIngredientsToRecipe(flour, 0.4));
    }

    @Test
    public void testAddIngredientsToRecipeWithWrongValues() {
        assertThrows(NullPointerException.class, () -> cookieRecipe.addIngredientsToRecipe(null, 10));
        assertThrows(NegativeNumException.class, () -> cookieRecipe.addIngredientsToRecipe(salt, -10));
    }

    @Test
    public void testGetQuantityOfIngredientsInRecipe() {
        assertEquals(10, cookieRecipe.getQuantityOfIngredients(eggs.getName()));
    }

    @Test
    public void testGetQuantityOfIngredientsInRecipeWithNull() {
        assertEquals(0, cookieRecipe.getQuantityOfIngredients(""));
    }

    @Test
    void testGetIngredientsAndQuantityInRecipe() {
        assertEquals(true, cookieRecipe.getIngredientsAndQuantityInRecipe().containsKey(oil.getName()));
        assertEquals(0.25, cookieRecipe.getIngredientsAndQuantityInRecipe().get(oil.getName()));
    }

    // This will print all the ingredients found in cake
    @Test
    void testGetAllIngredientsInRecipe() {
        double price = 0;
        for (Map.Entry<Ingredient, Double> item : cookieRecipe.getAllIngredientsInRecipe().entrySet()) {
            if (item.getKey().getName().equals(salt.getName())) {
                price = item.getKey().getPrice();
            }
        }
        assertEquals(true, cookieRecipe.getAllIngredientsInRecipe().containsKey(salt));
        assertEquals(10, cookieRecipe.getAllIngredientsInRecipe().get(salt));
        assertEquals(salt.getPrice(), price);
    }

    @Test
    void testGetNumberOfItemsCreated() {
        assertEquals(12, cookieRecipe.getNumberOfItemsCreated());
    }

    //US 4 test cases
    @Test
    void testCalcAmountOfIngredientsToPurchase() {
//         cookieRecipe has (sugar, 0.4) and icing has (sugar, 0.5); ;
        Map<Ingredient, Double> cookiePurchase = cookieRecipe.calcAmountOfIngredientsToPurchaseOnce();
        assertEquals(1, cookiePurchase.get(sugar));
//        // cakeRecipe has (sugar, 0.4)
        Map<Ingredient, Double> cakePurchase = cakeRecipe.calcAmountOfIngredientsToPurchaseOnce();
        assertEquals(0.4, cakePurchase.get(sugar));
        // icing has (sugar, 0.5)
        Map<Ingredient, Double> icingPurchase = icing.calcAmountOfIngredientsToPurchaseOnce();
        assertEquals(0.5, icingPurchase.get(sugar));
    }


    //US 5 test cases
    @Test
    void testCalcAmountOfIngredientsToPurchasePerRecipe() {
        // cookieRecipe has (sugar, 0.5) and icing has (sugar, 0.5); ;
        Map<Ingredient, Double> cookiePurchase = cookieRecipe.calcAmountOfIngredientsToPurchase(1);
        assertEquals(1, cookiePurchase.get(sugar));
        // cakeRecipe has (sugar, 0.4)
        Map<Ingredient, Double> cakePurchase = cakeRecipe.calcAmountOfIngredientsToPurchase(1);
        assertEquals(0.4, cakePurchase.get(sugar));
        // icing has (sugar, 0.5)
        Map<Ingredient, Double> icingPurchase = icing.calcAmountOfIngredientsToPurchase(3);
        assertEquals(1.5, icingPurchase.get(sugar));
    }

    @Test
    void testAddSubRecipe() {
        assertTrue(cookieRecipe.addSubRecipe(icing, 2));
    }

    @Test
    void testAddSubRecipeWithNegativeQuantity() {
        assertThrows(Exception.class, () -> cookieRecipe.addSubRecipe(icing, 0));
    }
}