package ui.mainframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class MainFrame extends JFrame implements ActionListener {

    private MainPageActionToolBar toolBar;
    private static int cal;
    private static int pro;
    private static int fat;
    private static int car;
    public static ProgressBarToolBar progressBarToolBar;



    private JButton dailyGoals;

    public MainFrame() {
        super("Fitness and Calorie Tracker");
        setVisible(true);


        setLayout(new BorderLayout());

        progressBarToolBar = new ProgressBarToolBar();

        toolBar = new MainPageActionToolBar();

        dailyGoals = new JButton("Set Daily Goals");
        dailyGoals.addActionListener(this);


        add(toolBar, BorderLayout.NORTH);
        add(dailyGoals, BorderLayout.SOUTH);
        add(progressBarToolBar, BorderLayout.CENTER);


        setSize(800, 700);

        this.setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void displayOut(String s, String s2) {
        JOptionPane.showMessageDialog(null, s,
                s2, JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        cal = parseInt(JOptionPane.showInputDialog("What is your daily Calorie goal?"));
        pro = parseInt(JOptionPane.showInputDialog("What is your daily Protein goal?"));
        fat = parseInt(JOptionPane.showInputDialog("What is your daily Fat goal?"));
        car = parseInt(JOptionPane.showInputDialog("What is your daily Carbohydrate goal?"));

        progressBarToolBar.setMaxCal(cal);
        progressBarToolBar.setMaxPro(pro);
        progressBarToolBar.setMaxFat(fat);
        progressBarToolBar.setMaxCar(car);

        displayOut("Daily Goals Set!", "Success!");

    }

}
