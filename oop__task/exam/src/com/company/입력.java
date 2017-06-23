package com.company;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class 입력 extends JDialog implements ActionListener {
    private static 입력 Instance;

    private final int   줄수     = 15;
    private JTextField[] htxt, itxt, mtxt, ftxt, atxt, rtxt;
    private 학생데이터 학생정보;
    private 출력 출;

    public static 입력 getInstance(JFrame f){
        if (Instance == null){
            Instance = new 입력(f);
        }
        return Instance;
    }

    private 입력(JFrame 소유자) { this(소유자, false); }

    private 입력(JFrame 소유자, boolean 모달) {
        super(소유자, "성적자료 입력", 모달);
        int i, x, y;


        JLabel hlbl = new JLabel("학   번", JLabel.CENTER);
        JLabel ilbl = new JLabel("이   름", JLabel.CENTER);
        JLabel mlbl = new JLabel("중   간", JLabel.CENTER);
        JLabel flbl = new JLabel("기   말", JLabel.CENTER);
        JLabel albl = new JLabel("출   석", JLabel.CENTER);
        JLabel rlbl = new JLabel("과   제", JLabel.CENTER);

        htxt = new JTextField[줄수];  itxt = new JTextField[줄수];
        mtxt = new JTextField[줄수];  ftxt = new JTextField[줄수];
        atxt = new JTextField[줄수];  rtxt = new JTextField[줄수];

        for (i = 0; i < 줄수; i++) {
            htxt[i] = new JTextField(3);  itxt[i] = new JTextField(4);
            mtxt[i] = new JTextField(2);  ftxt[i] = new JTextField(2);
            atxt[i] = new JTextField(2);  rtxt[i] = new JTextField(2);
        }


        JButton 완료단추 = new JButton("입력완료");
        완료단추.addActionListener(this);

        setLayout(null);
        hlbl.setBounds( 10, 30, 50, 30);  ilbl.setBounds( 70, 30, 50, 30);
        mlbl.setBounds(130, 30, 50, 30);  flbl.setBounds(190, 30, 50, 30);
        albl.setBounds(250, 30, 50, 30);  rlbl.setBounds(310, 30, 50, 30);

        x = 10;  y = 70;
        for (i = 0; i < 줄수; i++) {
            htxt[i].setBounds(x, y, 50, 20);       itxt[i].setBounds(x+60, y, 50, 20);
            mtxt[i].setBounds(x+120, y, 30, 20); ftxt[i].setBounds(x+190, y, 30, 20);
            atxt[i].setBounds(x+250, y, 30, 20);  rtxt[i].setBounds(x+310, y, 30, 20);
            y = y + 25;
        }
        완료단추.setBounds(220, 450, 100, 25);

        add(hlbl);  add(ilbl);
        add(mlbl);  add(flbl);  add(albl);  add(rlbl);
        for (i = 0; i < 줄수; i++) {
            add(htxt[i]);  add(itxt[i]);  add(mtxt[i]);
            add(ftxt[i]);  add(atxt[i]);  add(rtxt[i]);
        }
        add(완료단추);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        ArrayList 정보들 = new ArrayList();
        학생정보 = 학생정보.getInstance();
        for(int i = 0 ; i < 줄수 ; i++){
            String[] s  = new String[]{ htxt[i].getText(), itxt[i].getText(),
                                        mtxt[i].getText(), ftxt[i].getText(),
                                        atxt[i].getText(), rtxt[i].getText(),
                                        "0", "0"};
            정보들.add(s);
        }

        학생정보.정보얻기(정보들);
        출 = 출력.getInstance();
        출.정보들얻기();
    }
}