package ui.mainframe;

import model.food.FoodMap;
import network.WebPageReader;
import ui.addfood.AddFoodFrame;
import ui.foodlist.FoodListFrame;
import ui.foodlist.RemoveFrame;
import ui.values.ValueFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class MainPageActionToolBar extends JPanel implements ActionListener {

    private JButton addFood;
    private JButton remove;
    private JButton view;
    private JButton values;
    private JButton funFact;
    private FoodMap foodMap;
    WebPageReader webPageReader;

    public MainPageActionToolBar() {

        addFood = new JButton("Add Food");
        addFood.addActionListener(this);

        remove = new JButton("Remove Food");
        remove.addActionListener(this);

        view = new JButton("Foods");
        view.addActionListener(this);

        values = new JButton("View Nutrition");
        values.addActionListener(this);

        funFact = new JButton("Daily Fact!");
        funFact.addActionListener(this);

        setLayout(new FlowLayout());

        add(addFood);
        add(remove);
        add(view);
        add(values);
        add(funFact);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();
        if (button == addFood) {
            addFoodAction();
        } else if (button == remove) {
            removeAction();
        } else if (button == view) {
            viewAction();
        } else if (button == values) {
            valuesAction();
        } else if (button == funFact) {
            funFactAction();
        }
    }

    private void valuesAction() {
        try {
            ValueFrame valueFrame = new ValueFrame();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void addFoodAction() {
        try {
            AddFoodFrame addFoodFrame = new AddFoodFrame();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void removeAction() {
        if (Main.foodMap.getFoodMap().isEmpty() && Main.foodMap.getCheatFoodMap().isEmpty()
                && Main.foodMap.getAlcoholMap().isEmpty()) {
            MainFrame.displayOut("It's Empty! Add some Food!", "Error!");
        } else {
            RemoveFrame removeFrame = new RemoveFrame();
        }
    }

    private void viewAction() {
        if (Main.foodMap.getFoodMap().isEmpty() && Main.foodMap.getCheatFoodMap().isEmpty()
                && Main.foodMap.getAlcoholMap().isEmpty()) {
            MainFrame.displayOut("It's Empty! Add some Food!", "Error!");
        } else {
            FoodListFrame foodListFrame = new FoodListFrame();
        }

    }

    private void funFactAction() {
        ImageIcon leBron = new ImageIcon("data/lebron.jpg");

        try {
            String toRead = webPageReader.webPage();
            JOptionPane.showMessageDialog(null, "\nFun fact: This is a LeBron James' game day breakfast! "
                    + "\n\n" + toRead + "\n", "Daily Fact of the Day!", JOptionPane.INFORMATION_MESSAGE, leBron);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}
