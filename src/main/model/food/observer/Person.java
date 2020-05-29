package model.food.observer;

import model.food.FoodMap;
import model.food.observer.FoodListObserver;
import model.food.observer.Subject;

public class Person implements FoodListObserver {
    String name;
    String type;

    public Person(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    @Override

    //REQUIRES: that observers not be empty
    //EFFECTS: notifies the observers
    public void update(FoodMap foodMap) {
        System.out.println(this.getName()
                + " has been notified that a new food has been added to your Food List: "
                + foodMap.getName());
    }
}
