package com.company;

import com.company.메뉴.메뉴판;
import com.company.메뉴.음식;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Osy on 2017-05-25.
 */
public class 주문대화창 extends JDialog{
    private final Frame owner;
    private JButton[] buttons;
    private 음식[] 메뉴판;
    private 메뉴판 메뉴;
    private String 주문음식;
    private int 하단위치;

    private final int 창크기_가로 = 800;
    private final int 창크기_세로 = 800;
    private final int 버튼_가로 = 창크기_가로/5;
    private final int 버튼_세로 = 창크기_세로/10;


    public 주문대화창(JFrame owner, String s) {
        super(owner, s);
        this.owner = owner;
        setSize(창크기_가로,창크기_세로);
        setLayout(null);

        메뉴판생성();
        선택음식();
        주문테이블();
        완료취소버튼();


        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
            }
        });
    }

    private void 메뉴판생성(){
        메뉴 = new 메뉴판();
        메뉴판 = 메뉴.메뉴판얻기();

        int 메뉴수 = 메뉴판.length;
        buttons = new JButton[메뉴수];

        for (int i = 0; i < 메뉴수 ; i++){
            String btnStr = 메뉴판[i].음식명받기();
            int 열 = i/3 +1;
            int 행 = i%3 +1;

            buttons[i] = new JButton(btnStr);
                buttons[i].setBounds(버튼_가로 * 행, 버튼_세로 * 열, 버튼_가로-20, 버튼_세로-20);
                buttons[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //음식명.setText(e.getActionCommand());
                        주문음식 = e.getActionCommand();

                            /*for (int i = 0; i < 수; i++){
                                if(model.getColumnName(i).equals(주문음식)){

                                }
                            }*/
                    }
                });
            add(buttons[i]);
        }
    }

    private void 선택음식(){

    }

    public void add(주문내역 t){
        JLabel[] a = t.getRow();

        for (int i = 0; i < a.length; i++){
            JLabel jl = a[i];
            add(jl);
        }
    }

    private void 주문테이블(){
        하단위치 = 메뉴판.length/3+2;

        주문내역 목록 = new 주문내역(3);
        목록.setBounds(버튼_가로, 버튼_세로*(하단위치), 300, 140);
        목록.setRow(new String[]{"음식명","수량","총가격"});
        add(목록);
    }

    private void 완료취소버튼(){
        JButton 완료 = new JButton("완료");
            완료.setBounds(창크기_가로*7/10 , 창크기_세로*3/5 ,  버튼_가로/2,버튼_세로/2 );
            완료.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    /*String 수량 = 수량입력.getText();
                    new 출력대화창(owner, 주문음식 , 수량);*/
                }
            });
        JButton 취소 = new JButton("취소");
            취소.setBounds(창크기_가로*7/10 , 창크기_세로*7/10 ,  버튼_가로/2,버튼_세로/2 );
            취소.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                        /*String 수량 = 수량입력.getText();
                        new 출력대화창(owner, 주문음식 , 수량);*/
                }
            });
        add(완료);
        add(취소);
    }


}