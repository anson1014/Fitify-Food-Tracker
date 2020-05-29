package model.food;


import model.food.observer.FoodListObserver;

public abstract class Food {
    private double calories;
    private double units;
    private double protein;
    private double fats;
    private double carbohydrates;



    //EFFECTS: constructs a new food with U, P, F, C in grams
    Food() {
    }

    public abstract void foodAdded();

    void setFoodWeight(double grams) {
        this.units = grams;
    }

    void setFoodCalories(double value) {
        this.calories = value;
    }

    void setFoodProtein(double proteins) {
        this.protein = proteins;
    }

    void setFoodFat(double fat) {
        this.fats = fat;
    }

    void setFoodCarbohydrates(double carbohydrate) {
        this.carbohydrates = carbohydrate;
    }

    public double getFoodWeight() {
        return units;
    }

    public double getFoodCalories() {
        return calories;
    }

    public double getProtein() {
        return protein;
    }

    public double getFat() {
        return fats;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }




}
