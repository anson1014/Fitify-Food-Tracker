package model.food.observer;

import model.food.FoodMap;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<FoodListObserver> observers = new ArrayList<>();

    //REQUIRES: observer is not already contained
    //MODIFIES: observers
    //EFFECTS: adds observer to list if not already in
    public void addObserver(FoodListObserver foodListObserver) {
        if (!observers.contains(foodListObserver)) {
            observers.add(foodListObserver);
        }
    }

    //EFFECTS: calls update on each of the observers
    public void notifyObservers(FoodMap foodMap) {
        for (FoodListObserver observer : observers) {
            observer.update(foodMap);
        }
    }
}
