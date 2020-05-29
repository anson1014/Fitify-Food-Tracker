package test;


import exceptions.Negative;
import exceptions.NoLimit;
import model.food.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FoodMapTest {

    FoodMap foodMap;
    FoodName Apples;
    FoodName Oranges;
    FoodName Pears;
    Alcohol regFood;



    @BeforeEach
    void runBefore() {
        foodMap = new FoodMap("Default");
        Apples = new FoodName("Apples");
        Oranges = new FoodName("Oranges");
        Pears = new FoodName("Pears");
    }

    @Test
    public void testAddNewFood() throws Negative {
        foodMap.foodAdder("Apples", 100, 199,
                200, 300, 413);
        assertTrue(foodMap.contains(Apples));
        assertEquals(foodMap.size(), 1);
        foodMap.printFoodList();
        foodMap.showValue(Apples);
    }



    @Test
    public void setterGetterTest() {

    }

    @Test
    public void testAddNewFoods() throws Negative {
        foodMap.foodAdder("Apples", 100, 199,
                200, 300, 413);
        assertTrue(foodMap.contains(Apples));
        foodMap.foodAdder("Oranges", 100, 199,
                200, 300, 413);
        assertTrue(foodMap.contains(Oranges));
        assertEquals(foodMap.size(), 2);
        foodMap.printFoodList();
        foodMap.showValue(Apples);
    }

    @Test
    public void testPrintOnEmpty() {
        assertEquals(foodMap.size(), 0);
        foodMap.printFoodList();
    }

    @Test
    public void testAddNewFoodsRemoveAllFoodsThenPrint() throws Negative {
        foodMap.foodAdder("Apples", 100, 199,
                200, 300, 413);
        assertTrue(foodMap.contains(Apples));
        foodMap.foodAdder("Oranges", 100, 199,
                200, 300, 413);
        assertTrue(foodMap.contains(Oranges));
        assertEquals(foodMap.size(), 2);
        foodMap.foodRemover(Apples);
        assertFalse(foodMap.contains(Apples));
        assertEquals(foodMap.size(), 1);
        foodMap.foodRemover(Oranges);
        assertFalse(foodMap.contains(Oranges));
        assertEquals(foodMap.size(), 0);
        foodMap.printFoodList();
    }

    @Test
    public void testAddNewFoodsRemoveFoodsThenPrint() throws Negative {
        foodMap.foodAdder("Apples", 100, 199,
                200, 300, 413);
        assertTrue(foodMap.contains(Apples));
        foodMap.foodAdder("Oranges", 100, 199,
                200, 300, 413);
        assertTrue(foodMap.contains(Oranges));
        assertEquals(foodMap.size(), 2);
        foodMap.foodRemover(Apples);
        assertFalse(foodMap.contains(Apples));
        assertEquals(foodMap.size(), 1);
        foodMap.printFoodList();
    }

    @Test
    public void testSumCal() throws Negative {
        foodMap.foodAdder("Apples", 100, 199,
                200, 300, 413);
        assertTrue(foodMap.contains(Apples));
        foodMap.foodAdder("Oranges", 100, 199,
                200, 300, 413);
        assertTrue(foodMap.contains(Apples));
        assertEquals(foodMap.size(), 2);
        assertEquals(foodMap.sumCal(), 200.0);
        foodMap.showValue(Apples);
        foodMap.showValue(Oranges);

}

    @Test
    public void testSumPro() throws Negative {
        foodMap.foodAdder("Apples", 100, 199,
                200, 300, 413);
        assertTrue(foodMap.contains(Apples));
        foodMap.foodAdder("Oranges", 100, 199,
                200, 300, 413);
        assertTrue(foodMap.contains(Oranges));
        assertEquals(foodMap.size(), 2);
        assertEquals(foodMap.sumPro(), 400);
        foodMap.showValue(Apples);
    }

    @Test
    public void testSumFat() throws Negative {
        foodMap.foodAdder("Apples", 100, 199,
                200, 300, 413);
        assertTrue(foodMap.contains(Apples));
        foodMap.foodAdder("Oranges", 100, 199,
                200, 300, 413);
        assertTrue(foodMap.contains(Oranges));
        assertEquals(foodMap.size(), 2);
        assertEquals(foodMap.sumFat(), 600);
    }

    @Test
    public void testSumCarbohydrates() throws Negative {
        foodMap.foodAdder("Apples", 100, 199,
                200, 300, 413);
        assertTrue(foodMap.contains(Apples));
        foodMap.foodAdder("Oranges", 100, 199,
                200, 300, 413);
        assertTrue(foodMap.contains(Oranges));
        assertEquals(foodMap.size(), 2);
        assertEquals(foodMap.sumCarbohydrates(), 826);
    }

    @Test
    public void testSumAll() throws Negative {
        foodMap.foodAdder("Apples", 100, 199,
                200, 300, 413);
        assertTrue(foodMap.contains(Apples));
        foodMap.foodAdder("Oranges", 100, 199,
                200, 300, 413);
        assertTrue(foodMap.contains(Oranges));
        assertEquals(foodMap.size(), 2);
        assertEquals(foodMap.sumCarbohydrates(), 826);
        assertEquals(foodMap.sumFat(), 600);
        assertEquals(foodMap.sumPro(), 400);
        assertEquals(foodMap.sumCal(), 200);
    }

    @Test
    public void cheatFoodAdderTest() throws Negative, NoLimit {
        foodMap.setLimit(5);
        foodMap.cheatFoodAdder("Apples", 100, 199,
                200, 300, 413);
        foodMap.setLimit(5 - 1);
        assertEquals(4, foodMap.getLimit());
        assertTrue(foodMap.contains(Apples));
    }

    @Test
    public void alcoholFoodAdderTest() throws Negative, NoLimit {
        foodMap.setLimit(5);
        foodMap.alcoholAdder("Apples", 100, 199,
                200, 300, 413);
        foodMap.setLimit(5 - 1);
        assertEquals(4, foodMap.getLimit());
        assertTrue(foodMap.contains(Apples));
    }

    @Test
    public void doubleAlcoholTest() throws Negative, NoLimit {
        foodMap.setLimit(5);
        foodMap.alcoholAdder("Apples", 100, 199,
                200, 300, 413);
        foodMap.setLimit(5 - 1);
        assertEquals(4, foodMap.getLimit());
        assertTrue(foodMap.contains(Apples));
        foodMap.setLimit(5);
        foodMap.alcoholAdder("Oranges", 100, 199,
                200, 300, 413);
        foodMap.setLimit(4 - 1);
        assertEquals(3, foodMap.getLimit());
        assertTrue(foodMap.contains(Oranges));
    }

    @Test
    public void doubleCheat() throws Negative, NoLimit {
        foodMap.setLimit(5);
        foodMap.cheatFoodAdder("Apples", 100, 199,
                200, 300, 413);
        foodMap.setLimit(5 - 1);
        assertEquals(4, foodMap.getLimit());
        assertTrue(foodMap.contains(Apples));
        foodMap.setLimit(5);
        foodMap.cheatFoodAdder("Oranges", 100, 199,
                200, 300, 413);
        foodMap.setLimit(4 - 1);
        assertEquals(3, foodMap.getLimit());
        assertTrue(foodMap.contains(Oranges));
    }

    @Test
    public void testAddNewVarietyRemoveFoodsThenPrint() throws Negative, NoLimit {
        foodMap.setLimit(5);
        foodMap.alcoholAdder("Apples", 100, 199,
                200, 300, 413);
        foodMap.foodAdder("Oranges", 100, 199,
                200, 300, 413);
        foodMap.cheatFoodAdder("Pears", 100, 199,
                200, 300, 413);
        foodMap.setLimit(5 - 2);
        assertEquals(3, foodMap.getLimit());
        assertTrue(foodMap.contains(Apples));
        assertTrue(foodMap.contains(Oranges));
        assertTrue(foodMap.contains(Pears));
        assertEquals(foodMap.size(), 3);
        foodMap.foodRemover(Apples);
        assertFalse(foodMap.contains(Apples));
        assertEquals(foodMap.size(), 2);
        foodMap.printFoodList();
    }

    @Test
    public void testEquals() {
        assertEquals(Apples, Apples);
    }



}


