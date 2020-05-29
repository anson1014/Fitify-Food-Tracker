package ui.foodlist;

import model.food.FoodMap;
import model.food.FoodName;
import ui.TextClass;
import ui.mainframe.Main;
import ui.mainframe.MainFrame;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import static ui.mainframe.MainFrame.displayOut;


public class RemoveFrame extends JFrame implements ActionListener {

    MainFrame mainFrame;
    private TextClass textClass;
    JPanel titlePanel;
    JLabel question;
    JButton remove;
    private FoodMap foodMap;


    public RemoveFrame() {

        super("Current List of Foods");
        setVisible(true);
        setSize(500, 500);
        setLayout(new BorderLayout());

        titlePanel = new JPanel();
        remove = new JButton("Select an item to remove");
        remove.addActionListener(this);

        question = new JLabel();
        question.setText("Here's what you have:");
        question.setFont(new Font("Aria", Font.BOLD, 20));

        titlePanel.add(question);

        textClass = new TextClass();
        add(textClass, BorderLayout.CENTER);
        add(titlePanel, BorderLayout.NORTH);
        add(remove, BorderLayout.SOUTH);
        this.setLocationRelativeTo(mainFrame);

        appendHandler();


    }

    private void appendHandler() {
        ArrayList<FoodName> foodNameList = new ArrayList<FoodName>(Main.foodMap.getFoodMap().keySet());
        ArrayList<FoodName> cheatNameList = new ArrayList<FoodName>(Main.foodMap.getCheatFoodMap().keySet());
        ArrayList<FoodName> alcoholNameList = new ArrayList<FoodName>(Main.foodMap.getAlcoholMap().keySet());
        textClass.appendText("REGULAR FOOD\n");
        textClass.appendText("————————————————————————————————————\n");
        foodListPrinter(foodNameList);
        textClass.appendText("\nCHEAT FOOD AND ALCOHOL\n");
        textClass.appendText("————————————————————————————————————\n");
        foodListPrinter(cheatNameList);
        foodListPrinter(alcoholNameList);

    }

    private void foodListPrinter(ArrayList<FoodName> list) {
        for (FoodName f : list) {
            textClass.appendText(f.getFoodName() + "\n");
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String remove = JOptionPane.showInputDialog("What would you like to remove?");
        FoodName toRemove = new FoodName(remove);
        Main.foodMap.foodRemover(toRemove);
        displayOut("Removed!", "Status");
        textClass.clear();
        appendHandler();
    }
}
