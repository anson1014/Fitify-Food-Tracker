package model.food;

public class Alcohol extends Food {
    @Override
    public void foodAdded() {
        System.out.println("Remember alcohol is all empty calories! Also make sure you enjoy responsibly!");
    }

}
