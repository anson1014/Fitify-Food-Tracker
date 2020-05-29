package ui.values;

import model.food.FoodMap;
import model.food.FoodName;
import ui.mainframe.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static ui.mainframe.MainFrame.displayOut;

public class ValueToolBar extends JPanel implements ActionListener {

    private Main main;
    private FoodMap foodMap;
    private FoodName foodName;
    private JButton cal;
    private JButton pro;
    private JButton fats;
    private JButton car;

    public ValueToolBar() throws IOException {

        BufferedImage calIcon = ImageIO.read(new File("C:\\Users\\anson\\Documents\\CPSC210\\calculatorsprite.png"));
        cal = new JButton(new ImageIcon(calIcon));
        cal.setBorder(BorderFactory.createEmptyBorder());
        cal.setContentAreaFilled(false);
        cal.addActionListener(this);

        BufferedImage proteinIcon = ImageIO.read(new File("C:\\Users\\anson\\Documents\\CPSC210\\chickensprite.png"));
        pro = new JButton(new ImageIcon(proteinIcon));
        pro.setBorder(BorderFactory.createEmptyBorder());
        pro.setContentAreaFilled(false);
        pro.addActionListener(this);

        BufferedImage fatIcon = ImageIO.read(new File("C:\\Users\\anson\\Documents\\CPSC210\\avocadosprite.png"));
        fats = new JButton(new ImageIcon(fatIcon));
        fats.setBorder(BorderFactory.createEmptyBorder());
        fats.setContentAreaFilled(false);
        fats.addActionListener(this);

        BufferedImage carIcon = ImageIO.read(new File("C:\\Users\\anson\\Documents\\CPSC210\\ricesprite.png"));
        car = new JButton(new ImageIcon(carIcon));
        car.setBorder(BorderFactory.createEmptyBorder());
        car.setContentAreaFilled(false);
        car.addActionListener(this);

        add(cal);
        add(pro);
        add(fats);
        add(car);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button == cal) {
            calAction();
        } else if (button == pro) {
            proAction();
        } else if (button == fats) {
            fatAction();
        } else if (button == car) {
            carAction();
        }
    }


    private void calAction() {
        Double calTotal = Main.foodMap.sumCal();
        displayOut("Here's your total Calories: " + calTotal.toString(), "Total Calories!");
    }

    private void proAction() {
        Double proTotal = Main.foodMap.sumPro();
        displayOut("Here's your total Protein: " + proTotal.toString(), "Total Protein!");
    }

    private void fatAction() {
        Double fatTotal = Main.foodMap.sumFat();
        displayOut("Here's your total Fats: " + fatTotal.toString(), "Total Fats!");
    }

    private void carAction() {
        Double carTotal = Main.foodMap.sumCarbohydrates();
        displayOut("Here's your total Carbohydrates: " + carTotal.toString(), "Total Carbohydrates!");
    }


}
