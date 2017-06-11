package com.company;

import com.company.주문대화창.주문내역;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by ce-416-46 on 2017-05-31.
 */
public class 주방장다이얼로그 extends Dialog{
    private final int 창크기_가로 = 500;
    private final int 창크기_세로 = 500;
    private final int 리스트_가로 = 150;
    private final int 리스트_세로 = 300;


    private Vector 만들것리스트;
    private Vector 만드는중리스트;

    private JList 만들것;
    private String 선택된것;


    public 주방장다이얼로그(Frame owner, String title) {
        super(owner, title);

        setSize(창크기_가로, 창크기_세로);
        setVisible(true);
        setLayout(null);

        만들것리스트 = new Vector();
        만드는중리스트 = new Vector();

        라벨생성("만들 것", 50);
        라벨생성("만드는 중인 것", 300);

        만들것 = 리스트생성(50);
            만들것.addListSelectionListener(리스트선택리스너);
        add(만들것);
        JList 만드는중리스트 = 리스트생성(300);
        add(만드는중리스트);


        JButton 옆으로 = new JButton(">>");
        옆으로.setBounds(225, 150, 50, 50);
        add(옆으로);
    }

    public void 주문내역얻기(ArrayList<주문내역> 주문내역들) {
        for (주문내역 주문 : 주문내역들){
            만들것리스트.addElement(주문.음식명얻기());
        }
        만들것.setListData(만들것리스트);
    }

    public void 라벨생성(String s, int x){
        JLabel 라벨 = new JLabel(s);
        라벨.setBounds(x, 50, 150, 50);
        라벨.setHorizontalAlignment(SwingConstants.CENTER);
        add(라벨);
    }

    public JList 리스트생성(int x){
        JList 리스트 = new JList();
        리스트.setBounds(x, 100 , 리스트_가로, 리스트_세로);
        return 리스트;
    }

    private ListSelectionListener 리스트선택리스너 = new ListSelectionListener(){

        @Override
        public void valueChanged(ListSelectionEvent e) {
            int i = e.getLastIndex();
              선택된것 = (String)만들것리스트.get(i);
        }
    };
}
