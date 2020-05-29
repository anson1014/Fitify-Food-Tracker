package ui.mainframe;

import model.food.FoodMap;

import javax.swing.*;
import java.awt.*;

public class ProgressBarToolBar extends JPanel {

    JLabel calT;
    JLabel proT;
    JLabel fatT;
    JLabel carT;
    JLabel limitT;

    JPanel ca;
    JPanel pr;
    JPanel fa;
    JPanel carb;
    JPanel li;


    static JProgressBar cal;
    static JProgressBar pro;
    static JProgressBar fat;
    static JProgressBar car;
    static JProgressBar limit;
    MainFrame mainFrame;
    Main main;
    FoodMap foodMap;

    public ProgressBarToolBar() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        Dimension d = new Dimension(600, 55);

        cal = new JProgressBar(0, 2000);
        cal.setStringPainted(true);
        cal.setMinimumSize(d);
        cal.setMaximumSize(d);

        pro = new JProgressBar(0, 2000);
        pro.setStringPainted(true);
        pro.setMinimumSize(d);
        pro.setMaximumSize(d);

        fat = new JProgressBar(0, 2000);
        fat.setStringPainted(true);
        fat.setMinimumSize(d);
        fat.setMaximumSize(d);

        car = new JProgressBar(0, 2000);
        car.setStringPainted(true);
        car.setMinimumSize(d);
        car.setMaximumSize(d);

        limit = new JProgressBar();
        limit.setStringPainted(true);
        limit.setMinimumSize(d);
        limit.setMaximumSize(d);


        calT = new JLabel();
        calT.setText("Daily Calorie Progress");
        calT.setFont(new Font("Aria", Font.BOLD, 20));

        proT = new JLabel();
        proT.setText("Daily Protein Progress");
        proT.setFont(new Font("Aria", Font.BOLD, 20));

        fatT = new JLabel();
        fatT.setText("Daily Fat Progress");
        fatT.setFont(new Font("Aria", Font.BOLD, 20));

        carT = new JLabel();
        carT.setText("Daily Carbohydrate Progress");
        carT.setFont(new Font("Aria", Font.BOLD, 20));

        limitT = new JLabel();
        limitT.setText("Limit Usage:");
        limitT.setFont(new Font("Aria", Font.BOLD, 20));

        ca = new JPanel();
        pr = new JPanel();
        fa = new JPanel();
        carb = new JPanel();
        li = new JPanel();


        ca.add(calT);
        add(cal);
        add(ca);

        pr.add(proT);
        add(pro);
        add(pr);

        fa.add(fatT);
        add(fat);
        add(fa);

        carb.add(carT);
        add(car);
        add(carb);


        li.add(limitT);
        add(limit);
        add(li);


    }

    public void setMaxCal(int n) {
        cal.setMaximum(n);
    }

    public void setMaxPro(int n) {
        pro.setMaximum(n);
    }

    public void setMaxFat(int n) {
        fat.setMaximum(n);
    }

    public void setMaxCar(int n) {
        car.setMaximum(n);
    }

    public void setMaxLimit(int n) {
        limit.setMaximum(n);
    }

    public void setCal(int n) {
        cal.setValue(n);
    }

    public void setPro(int n) {
        pro.setValue(n);
    }

    public void setFat(int n) {
        fat.setValue(n);
    }

    public void setCar(int n) {
        car.setValue(n);
    }

    public void setLimit() {
        limit.setValue(+ 1);
    }
}
