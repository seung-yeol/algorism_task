package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Osy on 2017-05-25.
 */
public class 출력대화창 extends Dialog {
    private String 음식명, 수량;

    public 출력대화창(Frame owner, String 음식명, String 수량) {
        super(owner);
        this.음식명 = 음식명;
        this.수량 = 수량;

        setSize(200,150);
        setVisible(true);
        setLayout(null);

        주문내역출력();
        확인버튼();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
            }
        });
    }

    private void 주문내역출력(){
        Label 주문내역 = new Label();
        주문내역.setText(음식명 +" "+ 수량 + "개 주문!!");
        주문내역.setBounds(40, 50, 130, 50);
        add(주문내역);
    }

    private void 확인버튼(){
        Button 확인 = new Button("확인");
        확인.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        확인.setBounds(80, 100, 40,30);
        add(확인);
    }
}