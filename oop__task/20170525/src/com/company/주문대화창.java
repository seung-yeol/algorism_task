package com.company;

import com.company.메뉴.메뉴판;
import com.company.메뉴.음식;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Osy on 2017-05-25.
 */
public class 주문대화창 extends Dialog{
    private final Frame owner;
    private Button[] buttons;
    private 음식[] 메뉴판;
    private Label 음식명;
    private 메뉴판 메뉴;
    private TextField 수량입력;
    private String 주문음식;
    private int 하단위치;

    public 주문대화창(Frame owner, String s) {
        super(owner, s);
        this.owner = owner;
        setSize(500,600);
        setLayout(null);

        메뉴판생성();
        선택음식();
        수량입력();
        완료버튼();

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
        buttons = new Button[메뉴수];

        for (int i = 0; i < 메뉴수 ; i++){
            String btnStr = 메뉴판[i].음식명받기();
            int 열 = i/3 +1;
            int 행 = i%3 +1;

            buttons[i] = new Button(btnStr);
                buttons[i].setBounds(100 * 행, 60 * 열, 90, 50);
                buttons[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        음식명.setText(e.getActionCommand());
                        주문음식 = e.getActionCommand();
                    }
                });
            add(buttons[i]);
        }
    }

    private void 선택음식(){
        하단위치 = 메뉴판.length/3 +2;
        음식명 = new Label("ㅎㅎ");
            음식명.setBounds(150, 60* 하단위치, 100, 50);
        add(음식명);
    }

    private void 수량입력(){
        수량입력 = new TextField("수량");
            수량입력.setBounds(250, 60* 하단위치 + 10, 100, 25);
        add(수량입력);
    }

    private void 완료버튼(){
        Button 완료 = new Button("완료");
            완료.setBounds(220 , 60 * (하단위치 +1), 60,30 );
            완료.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);

                    String 수량 = 수량입력.getText();
                    new 출력대화창(owner, 주문음식 , 수량);
                }
            });
        add(완료);
    }
}