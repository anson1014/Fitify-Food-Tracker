package test;

import exceptions.Negative;
import exceptions.NoLimit;
import model.food.FoodMap;
import model.food.FoodName;
import model.food.Limit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FoodMapExceptionsTest {

    FoodMap foodMap;
    FoodName Apples;
    FoodName Oranges;
    FoodName Pears;
    Limit limit = new Limit();

    @BeforeEach
    void runBefore() {
        foodMap = new FoodMap("Default");
        Apples = new FoodName("Apples");
        Oranges = new FoodName("Oranges");
        Pears = new FoodName("Pears");
    }

    @Test
    public void noExceptionThrownSingle() {
        try {
            foodMap.foodAdder("Apples", 100, 199,
                    200, 300, 413);
        } catch (Negative negative) {
            fail("This wasn't negative.");
        }
        assertTrue(foodMap.contains(Apples));
        assertEquals(foodMap.size(), 1);
        foodMap.printFoodList();
    }

    @Test
    public void noExceptionOnPlural() {
        try {
            foodMap.foodAdder("Apples", 100, 199,
                    200, 300, 413);
            foodMap.foodAdder("Oranges", 100, 199,
                    200, 300, 413);
        } catch (Negative negative) {
            fail("No negatives were added.");
        }
        assertTrue(foodMap.contains(Apples));
        assertTrue(foodMap.contains(Oranges));
        assertEquals(foodMap.size(), 2);
        foodMap.printFoodList();
    }

    @Test
    public void throwExceptionNegativeCal() {
        try {
            foodMap.foodAdder("Apples", -100, 199,
                    200, 300, 413);
        } catch (Negative negative) {
            negative.printStackTrace();
        }
    }

    @Test
    public void throwExceptionNegativeUnits() {
        try {
            foodMap.foodAdder("Apples", 100, -199,
                    200, 300, 413);
        } catch (Negative negative) {
            negative.printStackTrace();
        }
    }

    @Test
    public void throwExceptionNegativeProtein() {
        try {
            foodMap.foodAdder("Apples", 100, 199,
                    -200, 300, 413);
        } catch (Negative negative) {
            negative.printStackTrace();
        }
    }

    @Test
    public void throwExceptionNegativeFats() {
        try {
            foodMap.foodAdder("Apples", 100, 199,
                    200, -300, 413);
        } catch (Negative negative) {
            negative.printStackTrace();
        }
    }

    @Test
    public void throwExceptionNegativeCar() {
        try {
            foodMap.foodAdder("Apples", 100, 199,
                    200, 300, -413);
        } catch (Negative negative) {
            negative.printStackTrace();
        }
    }

    @Test
    public void throwExceptionNegatives() {
        try {
            foodMap.foodAdder("Apples", -100, -199,
                    -200, -300, -413);
        } catch (Negative negative) {
            negative.printStackTrace();
        }
    }

    @Test
    public void throwExceptionCheatNegativesAndNoLimit() throws Negative {
        foodMap.setLimit(0);
        try {
            foodMap.cheatFoodAdder("Apples", 100, 199,
                    200, 300, 413);
        } catch (Negative negative) {
            negative.printStackTrace();
        } catch (NoLimit noLimit) {
            noLimit.printStackTrace();
        }
    }

    @Test
    public void throwExceptionAlcNegativesAndNoLimit() throws Negative {
        foodMap.setLimit(0);
        try {
            foodMap.alcoholAdder("Apples", 100, 199,
                    200, 300, 413);
        } catch (Negative negative) {
            negative.printStackTrace();
        } catch (NoLimit noLimit) {
            noLimit.printStackTrace();
        }
    }

    @Test
    public void throwExceptionAlcoholNegatives() throws Negative {
        foodMap.setLimit(1);
        try {
            foodMap.alcoholAdder("Apples", -100, 199,
                    200, 300, 413);
        } catch (Negative negative) {
            negative.printStackTrace();
        } catch (NoLimit noLimit) {
            fail();
        }
    }

    @Test
    public void throwExceptionCheatNegatives() throws Negative {
        foodMap.setLimit(1);
        try {
            foodMap.cheatFoodAdder("Apples", -100, 199,
                    200, 300, 413);
        } catch (Negative negative) {
            negative.printStackTrace();
        } catch (NoLimit noLimit) {
            fail();
        }
    }

    @Test
    public void throwExceptionCheatcNegatives() throws Negative {
        foodMap.setLimit(1);
        try {
            foodMap.cheatFoodAdder("Apples", 100, -199,
                    200, 300, 413);
        } catch (Negative negative) {
            negative.printStackTrace();
        } catch (NoLimit noLimit) {
            fail();
        }
    }

    @Test
    public void throwExceptionCheatpNegatives() throws Negative {
        foodMap.setLimit(1);
        try {
            foodMap.cheatFoodAdder("Apples", 100, 199,
                    -200, 300, 413);
        } catch (Negative negative) {
            negative.printStackTrace();
        } catch (NoLimit noLimit) {
            fail();
        }
    }

    @Test
    public void throwExceptionCheatfNegatives() throws Negative {
        foodMap.setLimit(1);
        try {
            foodMap.cheatFoodAdder("Apples", 100, 199,
                    -200, -300, 413);
        } catch (Negative negative) {
            negative.printStackTrace();
        } catch (NoLimit noLimit) {
            fail();
        }
    }

    @Test
    public void throwExceptionCheatcaNegatives() throws Negative {
        foodMap.setLimit(1);
        try {
            foodMap.cheatFoodAdder("Apples", 100, 199,
                    -200, 300, -413);
        } catch (Negative negative) {
            negative.printStackTrace();
        } catch (NoLimit noLimit) {
            fail();
        }
    }


    @Test
    public void throwExceptionNoLimit() throws Negative {
        foodMap.setLimit(1);
        try {
            foodMap.cheatFoodAdder("Apples", 100, 199,
                    200, 300, 413);
        } catch (Negative negative) {
            fail("Not yet negative.");
        } catch (NoLimit noLimit) {
            noLimit.printStackTrace();
        }
    }




}



