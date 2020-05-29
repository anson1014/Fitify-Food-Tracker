package model.food;


import exceptions.Negative;
import exceptions.NoLimit;
import model.food.observer.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FoodMap extends Subject {

    String name;
    private Map<FoodName, Food> foodMap = new HashMap<>();
    private Map<FoodName,Food> cheatFoodMap = new HashMap<>();
    private Map<FoodName,Food> alcoholMap = new HashMap<>();
    private Limit limit = new Limit();


    public FoodMap(String s) {
        this.name = s;
    }


    public String getName() {
        return name;
    }


    //MODIFIES: this
    //EFFECTS: adds food to the list, duplicates are allowed.
    public void foodAdder(String foodName, double calories, double units,
                          double protein, double fats, double carbohydrates) throws Negative {
        if (negative(calories) || negative(units) || negative(protein) || negative(fats) || negative(carbohydrates)) {
            throw new Negative();
        }
        Food food = new RegFood();
        food.setFoodCalories(calories);
        food.setFoodWeight(units);
        food.setFoodProtein(protein);
        food.setFoodFat(fats);
        food.setFoodCarbohydrates(carbohydrates);
        FoodName name = new FoodName(foodName);
        foodMap.put(name, food);
        notifyObservers(this);
        food.foodAdded();
    }

    //MODIFIES: this
    //EFFECTS: adds food to the list, duplicates are allowed.
    public void cheatFoodAdder(String foodName, double calories, double units,
                               double protein, double fats, double carbohydrates) throws Negative, NoLimit {
        if (negative(calories) || negative(units) || negative(protein) || negative(fats) || negative(carbohydrates)) {
            throw new Negative();
        }
        limit.noLimit();
        Food food = new CheatFood();
        food.setFoodCalories(calories);
        food.setFoodWeight(units);
        food.setFoodProtein(protein);
        food.setFoodFat(fats);
        food.setFoodCarbohydrates(carbohydrates);
        FoodName name = new FoodName(foodName);
        cheatFoodMap.put(name, food);
        foodMap.put(name, food);
        notifyObservers(this);
        food.foodAdded();
    }


    //MODIFIES: this
    //EFFECTS: adds food to the list, duplicates are allowed.
    public void alcoholAdder(String foodName, double calories, double units,
                             double protein, double fats, double carbohydrates) throws Negative, NoLimit {
        if (negative(calories) || negative(units) || negative(protein) || negative(fats) || negative(carbohydrates)) {
            throw new Negative();
        }
        limit.noLimit();
        Food food = new Alcohol();
        food.setFoodCalories(calories);
        food.setFoodWeight(units);
        food.setFoodProtein(protein);
        food.setFoodFat(fats);
        food.setFoodCarbohydrates(carbohydrates);
        FoodName name = new FoodName(foodName);
        alcoholMap.put(name, food);
        foodMap.put(name, food);
        notifyObservers(this);
        food.foodAdded();
    }


    //MODIFIES: this
    //EFFECTS: sets the limit
    public void setLimit(double i) throws Negative {
        limit.setLimit(i);
    }

    public double getLimit() {
        return limit.getLimit();
    }



    //MODIFIES: this
    //EFFECTS: if food is in the list it gets removed, else do nothing.
    public void foodRemover(FoodName food) {
        foodMap.remove(food);
        alcoholMap.remove(food);
        cheatFoodMap.remove(food);
    }

    //EFFECTS: prints the current list of foods.
    public void printFoodList() {
        if (foodMap.isEmpty() && cheatFoodMap.isEmpty() && alcoholMap.isEmpty()) {
            System.out.println("It's empty! Add some food!");
        } else {
            ArrayList<FoodName> foodNameList = new ArrayList<FoodName>(foodMap.keySet());
            ArrayList<FoodName> cheatNameList = new ArrayList<FoodName>(cheatFoodMap.keySet());
            ArrayList<FoodName> alcoholNameList = new ArrayList<FoodName>(alcoholMap.keySet());
            System.out.println("ALL FOOD:");
            foodListPrinter(foodNameList);
            System.out.println("CHEAT FOOD AND ALCOHOL:");
            foodListPrinter(cheatNameList);
            foodListPrinter(alcoholNameList);
        }
    }

    //EFFECTS: prints out each item in the list
    private void foodListPrinter(ArrayList<FoodName> list) {
        for (FoodName f : list) {
            System.out.println(f.getFoodName());
        }

    }


    public Map<FoodName, Food> getFoodMap() {
        return foodMap;
    }

    public Map<FoodName, Food> getCheatFoodMap() {
        return cheatFoodMap;
    }

    public Map<FoodName, Food> getAlcoholMap() {
        return alcoholMap;
    }

    //EFFECTS: returns the size of the list.
    public int size() {
        return foodMap.size();
    }

    //EFFECTS: true if food is contained in the list, else false.
    public boolean contains(FoodName s) {
        return foodMap.containsKey(s);
    }


    //EFFECTS: sums the value of each food in the list
    public double sumCal() {
        ArrayList<FoodName> foodNameList = new ArrayList<FoodName>(foodMap.keySet());
        return summer(foodNameList, 1);
    }


    //EFFECTS: sums the value of each food in the list
    public double sumPro() {
        ArrayList<FoodName> foodNameList = new ArrayList<FoodName>(foodMap.keySet());
        return summer(foodNameList, 2);
    }

    //EFFECTS: sums the value of each food in the list
    public double sumFat() {
        ArrayList<FoodName> foodNameList = new ArrayList<FoodName>(foodMap.keySet());
        return summer(foodNameList, 3);
    }

    //EFFECTS: sums the value of each food in the list
    public double sumCarbohydrates() {
        ArrayList<FoodName> foodNameList = new ArrayList<FoodName>(foodMap.keySet());
        return summer(foodNameList, 4);
    }

    //EFFECTS: the backend for each of the sum functions
    private double summer(ArrayList<FoodName> f, int i) {
        double sum = 0;
        for (FoodName foodTitle : f) {
            Food food = foodMap.get(foodTitle);
            double add = giveValue(food, i);
            sum += add;
        }
        return sum;
    }

    //EFFECTS: the switch handler case for each of the nutrients
    private double giveValue(Food f, int i) {
        switch (i) {
            case 1:
                return f.getFoodCalories();

            case 2:
                return f.getProtein();

            case 3:
                return f.getFat();

            case 4:
                return f.getCarbohydrates();

            default: return 0;
        }

    }

    public boolean negative(double x) {
        return x < 0;
    }


    //EFFECTS: takes in the list and prints out each of its values
    public Food showValue(FoodName food) {
        if (!contains(food)) {
            return null;
        } else {
            Food values = foodMap.get(food);
            System.out.println("Calories: " + values.getFoodCalories());
            System.out.println("Amount: " + values.getFoodWeight() + " grams");
            System.out.println("Protein: " + values.getProtein() + " grams");
            System.out.println("Fat: " + values.getFat() + " grams");
            System.out.println("Carbohydrates: " + values.getCarbohydrates() + " grams");
            return values;
        }

    }


}
