package ui.values;

import model.food.Food;
import model.food.FoodMap;
import model.food.FoodName;
import ui.TextClass;
import ui.mainframe.Main;
import ui.mainframe.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import static ui.mainframe.MainFrame.displayOut;

public class ValueFrame extends JFrame implements ActionListener {

    ValueToolBar valueToolBar;
    MainFrame mainFrame;

    private JButton specificFood;
    JPanel titlePanel;
    JLabel question;

    private TextClass textClass;
    private FoodMap foodMap;

    public ValueFrame() throws IOException {

        super("See Food Values");
        setVisible(true);
        setLayout(new BorderLayout());

        titlePanel = new JPanel();

        question = new JLabel();
        question.setText("Which total would you like to view?");
        question.setFont(new Font("Aria", Font.BOLD, 20));

        titlePanel.add(question);

        specificFood = new JButton("View Specific Food");
        specificFood.addActionListener(this);

        valueToolBar = new ValueToolBar();

        add(titlePanel, BorderLayout.NORTH);
        add(valueToolBar, BorderLayout.CENTER);
        add(specificFood, BorderLayout.SOUTH);
        pack();
        this.setLocationRelativeTo(mainFrame);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        textClass = new TextClass();
        String select = JOptionPane.showInputDialog("What would you like to view?");
        FoodName selected = new FoodName(select);
        Food values = Main.foodMap.showValue(selected);
        if (values == null) {
            displayOut("Couldn't find food " + select, "Error!");
        } else {
            displayOut("Calories: " + values.getFoodCalories()
                    + "\nAmount: " + values.getFoodWeight() + " grams"
                    + "\nProtein: " + values.getProtein() + " grams"
                    + "\nFat: " + values.getFat() + " grams"
                    + "\nCarbohydrates: " + values.getCarbohydrates() + " grams", select);
        }
    }







}
