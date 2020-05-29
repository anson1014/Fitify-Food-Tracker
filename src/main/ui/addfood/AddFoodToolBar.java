package ui.addfood;

import exceptions.Negative;
import exceptions.NoLimit;
import model.food.FoodMap;
import ui.mainframe.Main;
import ui.mainframe.MainFrame;
import ui.mainframe.ProgressBarToolBar;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static ui.mainframe.MainFrame.displayOut;

public class AddFoodToolBar extends JPanel implements ActionListener {

    private JButton addReg;
    private JButton addCheat;
    private JButton addAlc;
    private FoodMap foodMap;
    private ProgressBarToolBar progressBarToolBar;

    public AddFoodToolBar() throws IOException {

        setLayout(new FlowLayout());

        BufferedImage regIcon = ImageIO.read(new File("C:\\Users\\anson\\Documents\\CPSC210\\regfoodsprite.png"));
        addReg = new JButton(new ImageIcon(regIcon));
        addReg.setBorder(BorderFactory.createEmptyBorder());
        addReg.setContentAreaFilled(false);
        addReg.addActionListener(this);


        BufferedImage cheatIcon = ImageIO.read(new File("C:\\Users\\anson\\Documents\\CPSC210\\cheatfoodsprite.png"));
        addCheat = new JButton(new ImageIcon(cheatIcon));
        addCheat.setBorder(BorderFactory.createEmptyBorder());
        addCheat.setContentAreaFilled(false);
        addCheat.addActionListener(this);


        BufferedImage alcIcon = ImageIO.read(new File("C:\\Users\\anson\\Documents\\CPSC210\\alcoholsprite.jpg"));
        addAlc = new JButton(new ImageIcon(alcIcon));
        addAlc.setBorder(BorderFactory.createEmptyBorder());
        addAlc.setContentAreaFilled(false);
        addAlc.addActionListener(this);



        add(addReg);
        add(addCheat);
        add(addAlc);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button == addReg) {
            addRegFoodAction();
        } else if (button == addCheat) {
            addCheatAction();
        } else if (button == addAlc) {
            addAlcAction();
        }
    }

    private void addRegFoodAction() {
        try {
            foodCreator();
            displayOut("Food Added! Good Choice!", "Success!");

        } catch (Negative negative) {
            displayOut("You can't input a negative value!", "Error!");
        }
    }


    private void addCheatAction() {
        try {
            cheatFoodCreator();
            displayOut("Food Added! Please limit yourself to only a few cheat items per week!",
                    "Success!");
        } catch (Negative negative) {
            displayOut("You can't input a negative value!", "Error!");
        } catch (NoLimit noLimit) {
            displayOut("You have no more cheat/alcohol foods left!", "Error!");
        }
        try {
            Main.foodMap.setLimit((Main.foodMap.getLimit() - 1));
            MainFrame.progressBarToolBar.setLimit();
        } catch (Negative negative) {
            displayOut("You can't have a negative limit!", "Error!");
        } finally {
            displayOut("Limit Updated!\nYou have " + Main.foodMap.getLimit()
                    + " cheat foods or alcohol left this week!", "Status");
        }
    }


    private void addAlcAction() {
        try {
            alcoholCreator();
            displayOut("Drink Added! Please enjoy responsibly!", "Success!");
        } catch (Negative negative) {
            displayOut("You can't input a negative value!", "Error!");
        } catch (NoLimit noLimit) {
            displayOut("You have no more cheat/alcohol foods left!", "Error!");
        }
        try {
            Main.foodMap.setLimit((Main.foodMap.getLimit() - 1));
            MainFrame.progressBarToolBar.setLimit();
        } catch (Negative negative) {
            displayOut("You can't have a negative limit!", "Error!");
        } finally {
            displayOut("Limit Updated!\nYou have " + Main.foodMap.getLimit()
                    + " cheat foods or alcohol left this week!", "Status");
        }
    }

    public void foodCreator() throws Negative {
        String name = JOptionPane.showInputDialog("What's the name of the Food?");
        Double amount = Double.parseDouble(JOptionPane.showInputDialog("How much are you adding in grams?"));
        Double calories = Double.parseDouble(JOptionPane.showInputDialog("How many calories are there?"));
        Double protein = Double.parseDouble(JOptionPane.showInputDialog("Add the Protein amount."));
        Double fat = Double.parseDouble(JOptionPane.showInputDialog("Add the Fat amount."));
        Double carbohydrates = Double.parseDouble(JOptionPane.showInputDialog("Add the Carbohydrate amount."));
        Main.foodMap.foodAdder(name, amount, calories, protein, fat, carbohydrates);
        barSetter();
    }

    public void cheatFoodCreator() throws Negative, NoLimit {
        String name = JOptionPane.showInputDialog("What's the name of the Food?");
        Double amount = Double.parseDouble(JOptionPane.showInputDialog("How much are you adding in grams?"));
        Double calories = Double.parseDouble(JOptionPane.showInputDialog("How many calories are there?"));
        Double protein = Double.parseDouble(JOptionPane.showInputDialog("Add the Protein amount."));
        Double fat = Double.parseDouble(JOptionPane.showInputDialog("Add the Fat amount."));
        Double carbohydrates = Double.parseDouble(JOptionPane.showInputDialog("Add the Carbohydrate amount."));
        Main.foodMap.cheatFoodAdder(name, amount, calories, protein, fat, carbohydrates);
        barSetter();
    }

    public void alcoholCreator() throws Negative, NoLimit {
        String name = JOptionPane.showInputDialog("What's the name of the drink?");
        Double amount = Double.parseDouble(JOptionPane.showInputDialog("How much are you adding in grams?"));
        Double calories = Double.parseDouble(JOptionPane.showInputDialog("How many calories are there?"));
        Double protein = Double.parseDouble(JOptionPane.showInputDialog("Add the Protein amount."));
        Double fat = Double.parseDouble(JOptionPane.showInputDialog("Add the Fat amount."));
        Double carbohydrates = Double.parseDouble(JOptionPane.showInputDialog("Add the Carbohydrate amount."));
        Main.foodMap.alcoholAdder(name, amount, calories, protein, fat, carbohydrates);
        barSetter();
    }

    public void barSetter() {
        MainFrame.progressBarToolBar.setCal((int)Main.foodMap.sumCal());
        MainFrame.progressBarToolBar.setPro((int)Main.foodMap.sumPro());
        MainFrame.progressBarToolBar.setFat((int)Main.foodMap.sumFat());
        MainFrame.progressBarToolBar.setCar((int)Main.foodMap.sumCarbohydrates());
    }




}
