package com.company;


import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class 입력 extends JDialog implements ActionListener {
    private static 입력 Instance;

    private final int   줄수     = 15;
    private JTextField[] 학번, 이름, 중간, 기말, 출석, 과제;
    private 학생데이터 학생정보;
    private 출력 출;
    private JFrame 소유자;

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
        this.소유자 = 소유자;


        JLabel 학번라벨 = new JLabel("학   번", JLabel.CENTER);
        JLabel 이름라벨 = new JLabel("이   름", JLabel.CENTER);
        JLabel 중간라벨 = new JLabel("중   간", JLabel.CENTER);
        JLabel 기말라벨 = new JLabel("기   말", JLabel.CENTER);
        JLabel 출석라벨 = new JLabel("출   석", JLabel.CENTER);
        JLabel 과제라벨 = new JLabel("과   제", JLabel.CENTER);

        학번 = new JTextField[줄수];  이름 = new JTextField[줄수];
        중간 = new JTextField[줄수];  기말 = new JTextField[줄수];
        출석 = new JTextField[줄수];  과제 = new JTextField[줄수];

        for (i = 0; i < 줄수; i++) {
            학번[i] = new JTextField(3);  이름[i] = new JTextField(4);
            중간[i] = new JTextField(2);  기말[i] = new JTextField(2);
            출석[i] = new JTextField(2);  과제[i] = new JTextField(2);
        }


        JButton 완료단추 = new JButton("입력완료");
        JButton 설정단추 = new JButton("설정");
        완료단추.addActionListener(this);
        설정단추.addActionListener(this);

        setLayout(null);
        학번라벨.setBounds( 10, 30, 50, 30);  이름라벨.setBounds( 70, 30, 50, 30);
        중간라벨.setBounds(130, 30, 50, 30);  기말라벨.setBounds(190, 30, 50, 30);
        출석라벨.setBounds(250, 30, 50, 30);  과제라벨.setBounds(310, 30, 50, 30);

        x = 10;  y = 70;
        for (i = 0; i < 줄수; i++) {
            학번[i].setBounds(x, y, 50, 20);       이름[i].setBounds(x+60, y, 50, 20);
            중간[i].setBounds(x+120, y, 30, 20); 기말[i].setBounds(x+190, y, 30, 20);
            출석[i].setBounds(x+250, y, 30, 20);  과제[i].setBounds(x+310, y, 30, 20);
            y = y + 25;
        }
        완료단추.setBounds(220, 450, 100, 25);
        설정단추.setBounds(60, 450, 100, 25);

        add(학번라벨);  add(이름라벨);
        add(중간라벨);  add(기말라벨);  add(출석라벨);  add(과제라벨);
        for (i = 0; i < 줄수; i++) {
            add(학번[i]);  add(이름[i]);  add(중간[i]);
            add(기말[i]);  add(출석[i]);  add(과제[i]);
        }
        add(완료단추);
        add(설정단추);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "입력완료" :
                ArrayList 정보들 = new ArrayList();
                학생정보 = 학생정보.getInstance();

                for(int i = 0 ; i < 줄수 ; i++){
                    String[] s  = new String[]{ 학번[i].getText(), 이름[i].getText(),
                            중간[i].getText(), 기말[i].getText(),
                            출석[i].getText(), 과제[i].getText(),
                            "0", "0"};
                    정보들.add(s);
                }
                학생정보.정보얻기(정보들);
                출 = 출력.getInstance();
                출.출력실행();
                break;

            case "설정" :
                new 설정창(소유자);
                break;
        }
    }
}