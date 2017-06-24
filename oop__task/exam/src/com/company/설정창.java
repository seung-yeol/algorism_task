package com.company;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Osy on 2017-06-23.
 */
public class 설정창 extends JDialog {
    private 학생데이터 학생정보 = 학생데이터.getInstance();
    private JTextField[] 학점점수필드;
    private int 중간비율, 기말비율, 출석비율, 과제비율;
    private JTextField 중간비율필드, 기말비율필드, 출석비율필드, 과제비율필드;

    public 설정창(JFrame 소유자){
        super(소유자, "설정창");

        setSize(400, 400);
        setLayout(null);
        setLocation(0, 400);

        학점설정설정();
        점수비율설정();
        확인버튼추가();

        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }
    private void 학점설정설정(){
        학점점수필드 = new JTextField[12];

        JLabel a = new JLabel("A");     JLabel b = new JLabel("B");
        JLabel c = new JLabel("C");     JLabel d = new JLabel("D");

        JLabel plus = new JLabel("+");     JLabel zero = new JLabel("0");
        JLabel minus = new JLabel("-");

        a.setBounds(50, 50, 50, 20);
        b.setBounds(50, 90, 50, 20);
        c.setBounds(50, 130, 50, 20);
        d.setBounds(50, 170, 50, 20);

        plus.setBounds(100, 20, 50, 20);
            plus.setHorizontalAlignment(SwingConstants.CENTER);
        zero.setBounds(170, 20, 50, 20);
            zero.setHorizontalAlignment(SwingConstants.CENTER);
        minus.setBounds(240, 20, 50, 20);
            minus.setHorizontalAlignment(SwingConstants.CENTER);

        add(a); add(b); add(c); add(d);
        add(plus); add(zero); add(minus);

        int[] 학점점수들 = 학생정보.학점점수얻기();
        for (int i = 0; i < 학점점수필드.length; i++){
            int 가로 = 100 + 70*(i%3);
            int 세로 = 50 + 40*(i/3);
            학점점수필드[i] = new JTextField();
            학점점수필드[i].setText(Integer.toString(학점점수들[i]));
            학점점수필드[i].setBounds(가로, 세로, 50, 20);
            학점점수필드[i].setHorizontalAlignment(SwingConstants.CENTER);
            add(학점점수필드[i]);
        }
    }
    private void 점수비율설정(){
        중간비율 = 학생정보.중간비율얻기();
        기말비율 = 학생정보.기말비율얻기();
        출석비율 = 학생정보.출석비율얻기();
        과제비율 = 학생정보.과제비율얻기();

        JLabel 중간비율라벨 = new JLabel("중간비율");
            중간비율라벨.setBounds(50, 240, 60, 20);
        JLabel 기말비율라벨 = new JLabel("기말비율");
            기말비율라벨.setBounds(113, 240, 60, 20);
        JLabel 출석비율라벨 = new JLabel("출석비율");
            출석비율라벨.setBounds(177, 240, 60, 20);
        JLabel 과제비율라벨 = new JLabel("과제비율");
            과제비율라벨.setBounds(240, 240, 60, 20);

        중간비율필드 = new JTextField();
            중간비율필드.setHorizontalAlignment(SwingConstants.CENTER);
            중간비율필드.setText(Integer.toString(중간비율));
            중간비율필드.setBounds(50, 270, 50, 20);
        기말비율필드 = new JTextField();
            기말비율필드.setHorizontalAlignment(SwingConstants.CENTER);
            기말비율필드.setText(Integer.toString(기말비율));
            기말비율필드.setBounds(113, 270, 50, 20);
        출석비율필드 = new JTextField();
            출석비율필드.setHorizontalAlignment(SwingConstants.CENTER);
            출석비율필드.setText(Integer.toString(출석비율));
            출석비율필드.setBounds(177, 270, 50, 20);
        과제비율필드 = new JTextField();
            과제비율필드.setHorizontalAlignment(SwingConstants.CENTER);
            과제비율필드.setText(Integer.toString(과제비율));
            과제비율필드.setBounds(240, 270, 50, 20);

        add(중간비율라벨);  add(기말비율라벨);  add(출석비율라벨);  add(과제비율라벨);
        add(중간비율필드);  add(기말비율필드);  add(출석비율필드);  add(과제비율필드);
    }
    private void 확인버튼추가(){
        JButton 확인버튼 = new JButton("확인");
            확인버튼.setBounds(140, 320, 80, 20);
            확인버튼.addActionListener(e -> {
                int 중간 = Integer.parseInt(중간비율필드.getText());
                int 기말 = Integer.parseInt(기말비율필드.getText());
                int 출석 = Integer.parseInt(출석비율필드.getText());
                int 과제 = Integer.parseInt(과제비율필드.getText());
                학생정보.점수반영비율(중간, 기말, 출석, 과제);

                int[] 학점점수 = new int[12];
                for (int i = 0; i < 학점점수필드.length; i++ ){
                    학점점수[i] = Integer.parseInt(학점점수필드[i].getText());
                }
                학생정보.학점점수설정(학점점수);
                dispose();
            });
        add(확인버튼);
    }
}
