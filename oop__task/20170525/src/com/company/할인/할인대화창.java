package com.company.할인;

import com.company.메뉴.메뉴판;
import com.company.메뉴.음식;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 * Created by ce-416-22 on 2017-06-12.
 */
public class 할인대화창 extends JDialog{
    private final int 창크기_가로 = 800;
    private final int 창크기_세로 = 800;
    private final int 라벨_가로 = 창크기_가로/5;
    private final int 라벨_세로 = 창크기_세로/15;
    private final JDialog THIS = this;

    private ArrayList<할인내역> 할인내역;

    public 할인대화창(JFrame frame) {
        super(frame, "할인대화창 창");

        setSize(창크기_가로,창크기_세로);
        setLayout(null);

        메뉴판나와랏();

        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    private void 메뉴판나와랏(){
        메뉴판 메뉴 = new 메뉴판();
        음식[] 메뉴판 = 메뉴.메뉴판얻기();

        for (int i = 0; i < 메뉴판.length; i++){
            메뉴판라벨 라벨 = new 메뉴판라벨(메뉴판[i].음식명받기());
            라벨.setBounds(100, 라벨_세로 * (i+1), 라벨_가로, 라벨_세로 -20);
            라벨.라벨들붙이기();
        }
    }


    private class 메뉴판라벨{
        private final int column = 2;

        private int 가로;
        private JLabel 음식라벨;
        private JTextField 할인필드;

        private 메뉴판라벨(String 음식명) {
            음식라벨 = new JLabel(음식명);
            할인필드 = new JTextField("0");
        }

        private void setBounds(int x, int y, int 가로, int 세로){
            this.가로 = 가로/column;
            음식라벨.setBounds(x + (this.가로), y, this.가로, 세로);
            할인필드.setBounds(x + (this.가로*2), y, this.가로, 세로);
        }

        private void 라벨들붙이기(){
            THIS.add(음식라벨);
            THIS.add(할인필드);
        }
    }
}