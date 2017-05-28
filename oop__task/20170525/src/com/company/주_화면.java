package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Osy on 2017-05-25.
 */
public class 주_화면 extends JFrame {
    주_화면(String title){
        super(title);
        JFrame f = this;

        setSize(300, 200);
        setVisible(true);
        setLayout(null);

        JButton 주문버튼 = new JButton("주문");
            주문버튼.setBounds(50,50,70,50);
        JButton 계산버튼 = new JButton("계산");
            계산버튼.setBounds(175,50,70,50);
        add(주문버튼);
        add(계산버튼);

        주문버튼.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                주문대화창 주문 = new 주문대화창(f, "주문");
                주문.setVisible(true);
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new 주_화면("식당 프로그램");
    }
}