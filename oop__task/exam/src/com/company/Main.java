package com.company;

import javax.swing.*;

/**
 * Created by ce-416-24 on 2017-06-21.
 */
public class Main {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        입력 입력창 = 입력.getInstance(f);
        출력 출력창 = 출력.getInstance(f);

        입력창.setSize     (400, 600);
        입력창.setLocation (400, 400);
        입력창.setResizable(false);
        입력창.setVisible  (true);

        출력창.setSize     (600, 600);
        출력창.setLocation (400, 400);
        출력창.setResizable(false);
        출력창.setVisible  (true);
    }
}
