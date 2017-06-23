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
public class 출력 extends JDialog implements ActionListener{
    private static 출력 Instance;

    private final int   줄수     = 15;
    private JLabel[] htxt, itxt, mtxt, ftxt, atxt, rtxt , 총점, 학점;
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

        JLabel hlbl = new JLabel("학   번", JLabel.CENTER);
        JLabel ilbl = new JLabel("이   름", JLabel.CENTER);
        JLabel mlbl = new JLabel("중   간", JLabel.CENTER);
        JLabel flbl = new JLabel("기   말", JLabel.CENTER);
        JLabel albl = new JLabel("출   석", JLabel.CENTER);
        JLabel rlbl = new JLabel("과   제", JLabel.CENTER);
        JLabel 총계표시 = new JLabel("총   계", JLabel.CENTER);
        JLabel 학점표시 = new JLabel("학   점", JLabel.CENTER);

        htxt = new JLabel[줄수];  itxt = new JLabel[줄수];
        mtxt = new JLabel[줄수];  ftxt = new JLabel[줄수];
        atxt = new JLabel[줄수];  rtxt = new JLabel[줄수];
        총점 = new JLabel[줄수];  학점 = new JLabel[줄수];

        for (i = 0; i < 줄수; i++) {
            htxt[i] = new JLabel();
            itxt[i] = new JLabel();
            mtxt[i] = new JLabel();
            ftxt[i] = new JLabel();
            atxt[i] = new JLabel();
            rtxt[i] = new JLabel();
            총점[i] = new JLabel();
            학점[i] = new JLabel();
        }

        setLayout(null);
        hlbl.setBounds( 10, 30, 50, 30);  ilbl.setBounds( 70, 30, 50, 30);
        mlbl.setBounds(130, 30, 50, 30);  flbl.setBounds(190, 30, 50, 30);
        albl.setBounds(250, 30, 50, 30);  rlbl.setBounds(310, 30, 50, 30);
        총계표시.setBounds(370, 30, 50, 30);  학점표시.setBounds(430, 30, 50, 30);

        x = 10;  y = 70;
        for (i = 0; i < 줄수; i++) {
            htxt[i].setBounds(x, y, 50, 20);       itxt[i].setBounds(x+60, y, 50, 20);
            mtxt[i].setBounds(x+120, y, 30, 20); ftxt[i].setBounds(x+190, y, 30, 20);
            atxt[i].setBounds(x+250, y, 30, 20);  rtxt[i].setBounds(x+310, y, 30, 20);
            총점[i].setBounds(x+370, y, 30, 20);  학점[i].setBounds(x+430, y, 30, 20);
            y = y + 25;
        }

        add(hlbl);  add(ilbl);  add(mlbl);  add(flbl);
        add(albl);  add(rlbl);  add(총계표시);  add(학점표시);
        for (i = 0; i < 줄수; i++) {
            add(htxt[i]);  add(itxt[i]);  add(mtxt[i]);
            add(ftxt[i]);  add(atxt[i]);  add(rtxt[i]);
            add(총점[i]);  add(학점[i]);
        }

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }

    public void 정보들얻기(){
        학생데이터 학생정보 = 학생데이터.getInstance();
        this.정보들 = 학생정보.정보주기();

        for (int i = 0; i < 줄수; i++) {
            String[] s = 정보들.get(i);
            htxt[i].setText(s[0]);
            itxt[i].setText(s[1]);
            mtxt[i].setText(s[2]);
            ftxt[i].setText(s[3]);
            atxt[i].setText(s[4]);
            rtxt[i].setText(s[5]);
            총점[i].setText(s[6]);
            학점[i].setText(s[7]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
