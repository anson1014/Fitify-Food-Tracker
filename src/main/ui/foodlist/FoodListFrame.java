package ui.foodlist;

import model.food.FoodMap;
import model.food.FoodName;
import ui.TextClass;
import ui.mainframe.Main;
import ui.mainframe.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FoodListFrame extends JFrame {

    MainFrame mainFrame;
    private TextClass textClass;
    JPanel titlePanel;
    JLabel label;
    private FoodMap foodMap;

    public FoodListFrame() {

        super("Current List of Foods");
        setVisible(true);
        setSize(500, 500);
        setLayout(new BorderLayout());

        titlePanel = new JPanel();
        label = new JLabel();
        label.setText("Here's what you have:");
        label.setFont(new Font("Aria", Font.BOLD, 20));

        titlePanel.add(label);

        textClass = new TextClass();
        add(textClass, BorderLayout.CENTER);
        add(titlePanel, BorderLayout.NORTH);

        this.setLocationRelativeTo(mainFrame);

        appendHandler();
    }

    private void appendHandler() {
        ArrayList<FoodName> foodNameList = new ArrayList<FoodName>(Main.foodMap.getFoodMap().keySet());
        ArrayList<FoodName> cheatNameList = new ArrayList<FoodName>(Main.foodMap.getCheatFoodMap().keySet());
        ArrayList<FoodName> alcoholNameList = new ArrayList<FoodName>(Main.foodMap.getAlcoholMap().keySet());
        textClass.appendText("REGULAR FOOD:\n");
        textClass.appendText("————————————————————————————————————\n");
        foodListPrinter(foodNameList);
        textClass.appendText("\nCHEAT FOOD AND ALCOHOL:\n");
        textClass.appendText("————————————————————————————————————\n");
        foodListPrinter(cheatNameList);
        foodListPrinter(alcoholNameList);
    }

    private void foodListPrinter(ArrayList<FoodName> list) {
        for (FoodName f : list) {
            textClass.appendText(f.getFoodName() + "\n");
        }
    }


}
