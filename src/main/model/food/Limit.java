package model.food;

import exceptions.Negative;
import exceptions.NoLimit;

public class Limit {
    double limit;


    //EFFECTS: sets the limit for a food
    public void setLimit(double i) throws Negative {
        if (negative(i)) {
            throw new Negative();
        } else {
            limit = i;
            System.out.println("New Limit set!");
        }
    }

    public double getLimit() {
        return limit;
    }

    public boolean negative(double x) {
        return x < 0;
    }


    //EFFECTS: throws the exception
    public void noLimit() throws NoLimit {
        if (limit <= 1) {
            throw new NoLimit();
        }
    }
}
