package ui.mainframe;


import exceptions.Negative;
import exceptions.NoLimit;
import exceptions.NotAnInput;
import model.*;
import model.food.FoodMap;
import model.food.FoodName;
import model.food.observer.Person;


import java.io.IOException;
import java.util.Scanner;

import static java.lang.Double.parseDouble;



public class Main {
    public static void main(String[] args) throws IOException {
        new MainFrame();
        new Main();
    }

    private Scanner scanner = new Scanner(System.in);
    public static FoodMap foodMap = new FoodMap("Default");

    //    Person person;
//    Exercise exercise;
    private String foodName;
    double calories;
    double units;
    double protein;
    double fats;
    double carbohydrates;
    double limit;
    String name;
    String type;

    private String userInput() {
        String input = "";
        input = scanner.nextLine();
        return input;
    }

    private Main() throws IOException {
        while (true) {
            Print print = new Print();
            print.printer();
            String input = userInput();
            try {
                invalidValThrower(input);
            } catch (NotAnInput notAnInput) {
                System.out.println("Sorry that is not a valid input!");
            }
            if (input.equals("1")) {
                userCreateFood();
                try {
                    foodMap.foodAdder(foodName, units, calories, protein, fats, carbohydrates);
                } catch (Negative negative) {
                    print.printNegative();
                }
            }
            if (input.equals("2")) {
                userCreateFood();
                try {
                    foodMap.cheatFoodAdder(foodName, units, calories, protein, fats, carbohydrates);
                } catch (Negative negative) {
                    print.printNegative();
                } catch (NoLimit noLimit) {
                    System.out.println("You have no more cheat/alcohol foods left!");
                }
                try {
                    foodMap.setLimit((foodMap.getLimit() - 1));
                } catch (Negative negative) {
                    System.out.println("You can't have a negative limit!");
                } finally {
                    System.out.println("You have " + foodMap.getLimit()
                            + " cheat foods or alcohol left this week!");
                }
            }
            if (input.equals("3")) {
                userCreateFood();
                try {
                    foodMap.alcoholAdder(foodName, units, calories, protein, fats, carbohydrates);
                } catch (Negative negative) {
                    print.printNegative();
                } catch (NoLimit noLimit) {
                    System.out.println("You have no more cheat/alcohol foods left!");
                }
                try {
                    foodMap.setLimit((foodMap.getLimit() - 1));
                } catch (Negative negative) {
                    print.printNegative();
                } finally {
                    System.out.println("You have " + foodMap.getLimit()
                            + " cheat foods or alcohol left this week!");
                }
            }
            if (input.equals("4")) {
                System.out.println("What would you like to remove?");
                FoodName name = new FoodName(userInput());
                foodMap.foodRemover(name);
                System.out.println("Removed!");
            }
            if (input.equals("5")) {
                foodMap.printFoodList();
            }
            if (input.equals("6")) {
                System.out.println("What food would you like to view?");
                foodMap.printFoodList();
                FoodName name = new FoodName(userInput());
                foodMap.showValue(name);
            }
            if (input.equals("7")) {
                print.printSumOptions();
                pickSum();
            }
            if (input.equals("8")) {
                System.out.println("Whats the limit?");
                limit = parseDouble(userInput());
                try {
                    foodMap.setLimit(limit);
                } catch (Negative negative) {
                    print.printNegative();;
                }
            }
            if (input.equals("9")) {
                userCreator();
                Person person = new Person(name, type);
                foodMap.addObserver(person);
                System.out.println("Person added!");
            }
            if (input.equals("10")) {
                break;
            }
//            if (input.equals("10")) {
//                System.out.println("What's the workout called?");
//                exerciseName = userInput();
//                exercise = new Exercise(exerciseName);
//                person.addWorkoutPlan(exercise);
//                System.out.println("Exercise added to " + person.getName() + "'s plan!");
//            }
//            if (input.equals("11")) {
//                System.out.println(person.getName() + "'s Exercises:");
//                person.printExercises();
//            }
//            if (input.equals("12")) {
//                System.out.println("Here's all the people doing: " + exercise.getExerciseName());
//                exercise.printPeople();
//            }
        }
    }

    private void userCreator() {
        System.out.println("Who's gonna be watching your diet?");
        name = userInput();
        System.out.println("What's his relationship to you? Example: Doctor, PT, Mom etc.");
        type = userInput();
    }

    private void userCreateFood() {
        System.out.println("What would you like to add?");
        foodName = userInput();
        System.out.println("How much are you adding (in grams)?");
        units = parseDouble(userInput());
        System.out.println("How many calories are there?");
        calories = parseDouble(userInput());
        System.out.println("Now add the Protein, Fat and Carbohydrate (in grams) of your food.");
        protein = parseDouble(userInput());
        fats = parseDouble(userInput());
        carbohydrates = parseDouble(userInput());
    }

    private void pickSum() {
        do {
            if (userInput().equals("1")) {
                System.out.println(foodMap.sumCal());
            }
            if (userInput().equals("2")) {
                System.out.println(foodMap.sumPro());
            }
            if (userInput().equals("3")) {
                System.out.println(foodMap.sumFat());
            }
            if (userInput().equals("4")) {
                System.out.println(foodMap.sumCarbohydrates());
            }
        } while (!userInput().equals("5"));
    }


    private void invalidValThrower(String x) throws NotAnInput {
        if (!x.equals("1") && !x.equals("2") && !x.equals("3") && !x.equals("4")
                && !x.equals("5") && !x.equals("6") && !x.equals("7") && !x.equals("8") && !x.equals("9")
                && !x.equals("10") && !x.equals("11") && !x.equals("12") && !x.equals("13")) {
            throw new NotAnInput();
        }
    }
}


