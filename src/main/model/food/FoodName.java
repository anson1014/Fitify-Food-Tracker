package model.food;

import java.util.Objects;

public class FoodName {
    String foodName;


    public FoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodName() {
        return foodName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FoodName foodName1 = (FoodName) o;
        return Objects.equals(foodName, foodName1.foodName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(foodName);
    }
}
