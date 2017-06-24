package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 * Created by ce-416-24 on 2017-06-21.
 */
public class 출력 extends JDialog{
    private static 출력 Instance;

    private final int   줄수     = 15;
    private JLabel[] 학번, 이름, 중간, 기말, 출석, 과제, 총점, 학점;
    private ArrayList<String[]> 정보들;

    public static 출력 getInstance(JFrame f){
        if (Instance == null){
            Instance = new 출력(f);
        }
        return Instance;
    }
    public static 출력 getInstance(){
        return Instance;
    }

    private 출력(JFrame 소유자) { this(소유자, false); }

    private 출력(JFrame 소유자, boolean 모달){
        super(소유자, "성적자료 출력", 모달);
        int i, x, y;

        JLabel 학번라벨 = new JLabel("학   번", JLabel.CENTER);
        JLabel 이름라벨 = new JLabel("이   름", JLabel.CENTER);
        JLabel 중간라벨 = new JLabel("중   간", JLabel.CENTER);
        JLabel 기말라벨 = new JLabel("기   말", JLabel.CENTER);
        JLabel 출석라벨 = new JLabel("출   석", JLabel.CENTER);
        JLabel 과제라벨 = new JLabel("과   제", JLabel.CENTER);
        JLabel 총계라벨 = new JLabel("총   계", JLabel.CENTER);
        JLabel 학점라벨 = new JLabel("학   점", JLabel.CENTER);

        학번 = new JLabel[줄수];  이름 = new JLabel[줄수];
        중간 = new JLabel[줄수];  기말 = new JLabel[줄수];
        출석 = new JLabel[줄수];  과제 = new JLabel[줄수];
        총점 = new JLabel[줄수];  학점 = new JLabel[줄수];

        for (i = 0; i < 줄수; i++) {
            학번[i] = new JLabel();
            이름[i] = new JLabel();
            중간[i] = new JLabel();
            기말[i] = new JLabel();
            출석[i] = new JLabel();
            과제[i] = new JLabel();
            총점[i] = new JLabel();
            학점[i] = new JLabel();
        }

        setLayout(null);
        학번라벨.setBounds( 10, 30, 50, 30);  이름라벨.setBounds( 70, 30, 50, 30);
        중간라벨.setBounds(130, 30, 50, 30);  기말라벨.setBounds(190, 30, 50, 30);
        출석라벨.setBounds(250, 30, 50, 30);  과제라벨.setBounds(310, 30, 50, 30);
        총계라벨.setBounds(370, 30, 50, 30);  학점라벨.setBounds(430, 30, 50, 30);

        x = 10;  y = 70;
        for (i = 0; i < 줄수; i++) {
            학번[i].setBounds(x, y, 50, 20);         이름[i].setBounds(x+60, y, 50, 20);
            중간[i].setBounds(x+120, y, 30, 20);  기말[i].setBounds(x+190, y, 30, 20);
            출석[i].setBounds(x+250, y, 30, 20);  과제[i].setBounds(x+310, y, 30, 20);
            총점[i].setBounds(x+370, y, 30, 20);  학점[i].setBounds(x+430, y, 30, 20);
            y = y + 25;
        }

        add(학번라벨);  add(이름라벨);  add(중간라벨);  add(기말라벨);
        add(출석라벨);  add(과제라벨);  add(총계라벨);  add(학점라벨);
        for (i = 0; i < 줄수; i++) {
            add(학번[i]);  add(이름[i]);  add(중간[i]);
            add(기말[i]);  add(출석[i]);  add(과제[i]);
            add(총점[i]);  add(학점[i]);
        }

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }

    public void 출력실행(){
        학생데이터 학생정보 = 학생데이터.getInstance();
        this.정보들 = 학생정보.정보주기();

        for (int i = 0; i < 줄수; i++) {
            String[] s = 정보들.get(i);
            학번[i].setText(s[0]);
            이름[i].setText(s[1]);
            중간[i].setText(s[2]);
            기말[i].setText(s[3]);
            출석[i].setText(s[4]);
            과제[i].setText(s[5]);
            총점[i].setText(s[6]);
            학점[i].setText(s[7]);
        }
    }
}