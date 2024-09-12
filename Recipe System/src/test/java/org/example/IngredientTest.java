package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientTest {
    Ingredient sugar, flour;

    @BeforeEach
    void initialValue() {
        sugar = new Ingredient("Sugar", 2.50, 1, Unit.kg, "Supplier A");
        flour = new Ingredient("Flour", 0, 0, Unit.kg, "Supplier B");
    }

    @Test
    void testCreateIngredient() {
        assertEquals("Sugar", sugar.getName());
        assertEquals(2.50, sugar.getPrice());
        assertEquals(1, sugar.getQuantity());
        assertEquals(Unit.kg, sugar.getUnit());
        assertEquals("Supplier A", sugar.getSupplierName());
    }

    @Test
    public void testGetTheNameIngredient() {
        assertEquals("Sugar", sugar.getName());
    }

    @Test
    void testModifyPrice() {
        assertEquals(2.5, sugar.getPrice());
    }

    @Test
    void testModifyPriceWithNegativeNum() throws Exception {
        assertThrows(Exception.class, () -> sugar.setPrice(-5.10));
    }
}