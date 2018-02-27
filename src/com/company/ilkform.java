package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ilkform {
    private JPanel panel1;
    private JButton vjvButton;

    public ilkform() {
        vjvButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { JOptionPane.showMessageDialog(null,"Merhaba Dünya");

            }


        });
    }
    public static void main(String[] args) {

        JFrame frame=new JFrame("Uygulama");
        frame.setContentPane(new ilkform().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}


