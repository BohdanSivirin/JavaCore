package annonymClasses.basic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        Action run = new Action() {
            @Override
            public void execute() {
                System.out.println("running...");
            }
//            @Override
//            public void method(){
//
//            }
        };
        run.execute();
        Action2 calculateDigits = new Action2() {
            @Override
            public int execute(String t) {
                int counter = 0;
                char[] array = t.toCharArray();
                for (int i = 0; i < array.length; i++) {
                    if (array[i] >= '0' && array[i] <= '9') {
                        counter++;
                    }
                }
                return counter;
            }
        };
        int num = calculateDigits.execute("quwrh139413-4r134tuojpasmdvamsd;vaaf5555");
        System.out.println(num);
        Animal bear = new Animal() {
            private int age = 7;

            public int getAge() {
                return age;
            }

            @Override
            public void voice() {
                System.out.println("Bear voice, bear age: " + getAge());
            }
        };
        bear.voice();
       new Dog() {
            private int age = 6;

            public void bite() {
                System.out.println(" baskerville likes biting ");
            }

            @Override
            public void voice() {
                System.out.println(" baskerville is barking ");
//                bite();
            }
        }.bite();
//        JFrame window = new JFrame("color window");
//        window.setLocationRelativeTo(null);
//        window.setSize(500, 400);
//        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        JPanel panel = new JPanel();
//        window.setLayout(new BorderLayout());
//        window.add(panel, BorderLayout.CENTER);
//        Panel botomPanel = new Panel(new FlowLayout());
//        JButton red = new JButton("red");
//        ActionListener actionListener = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                panel.setBackground(Color.RED);
//            }
//        };
//        red.addActionListener(actionListener);
//        ActionListener al = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                panel.setBackground(Color.BLUE);
//            }
//        };
//        JButton blue = new JButton("blue");
//        blue.addActionListener(al);
//        botomPanel.add(red);
//        botomPanel.add(blue);
//        window.add(botomPanel, BorderLayout.SOUTH);
//        window.setVisible(true);








    }


}


