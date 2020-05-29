package model.food;

public class CheatFood extends Food {
    @Override
    public void foodAdded() {
        System.out.println("Please limit yourself to only a few cheat foods a week!");
    }

}
