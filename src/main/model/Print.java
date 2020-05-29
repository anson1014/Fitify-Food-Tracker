package model;



public class Print {

    public void printer() {
        System.out.println("What would you like to do? Please Select");
        System.out.println(" [1] Add Food");
        System.out.println(" [2] Add a Cheat Food");
        System.out.println(" [3] Add Alcohol");
        System.out.println(" [4] Remove Food");
        System.out.println(" [5] View Current Food List");
        System.out.println(" [6] See Food Values");
        System.out.println(" [7] View Totals");
        System.out.println(" [8] Set Limit For Alcohol and Cheat Foods");
        System.out.println(" [9] Add someone to watch your diet");
        System.out.println(" [10] Exit");
    }

    public void printSumOptions() {
        System.out.println("What value would you like to view?");
        System.out.println(" [1] Calories");
        System.out.println(" [2] Protein");
        System.out.println(" [3] Fats");
        System.out.println(" [4] Carbohydrates");
        System.out.println(" [5] Exit");
    }

    public void printNegative() {
        System.out.println("You can't have a negative value! Try again.");
    }


}


