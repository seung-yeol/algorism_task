package com.company;

import com.company.메뉴.메뉴판;
import com.company.메뉴.음식;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Created by Osy on 2017-05-25.
 */
public class 주문대화창 extends JDialog{
    private 차림표버튼[] buttons;
    private 음식[] 메뉴판;
    private 메뉴판 메뉴;
    private int 하단위치;

    private ArrayList<주문내역> 주문내역들;

    private final int 창크기_가로 = 800;
    private final int 창크기_세로 = 800;
    private final int 버튼_가로 = 창크기_가로/5;
    private final int 버튼_세로 = 창크기_세로/10;

    private int rowCount;   //위치를 위한


    public 주문대화창(JFrame owner, String s) {
        super(owner, s);
        rowCount = 0;
        주문내역들 = new ArrayList();

        setSize(창크기_가로,창크기_세로);
        setLayout(null);

        메뉴판생성();
        주문테이블();
        완료취소버튼();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    private void 메뉴판생성(){
        메뉴 = new 메뉴판();
        메뉴판 = 메뉴.메뉴판얻기();

        int 메뉴수 = 메뉴판.length;
        buttons = new 차림표버튼[메뉴수];

        for (int i = 0; i < 메뉴수 ; i++){
            String btnStr = 메뉴판[i].음식명받기();
            int 열 = i/3 +1;
            int 행 = i%3 +1;

            buttons[i] = new 차림표버튼(btnStr);
                buttons[i].setBounds(버튼_가로 * 행, 버튼_세로 * 열, 버튼_가로-20, 버튼_세로-20);
                buttons[i].addActionListener(클릭리스너);
                buttons[i].음식설정(메뉴판[i]);
            add(buttons[i]);
        }
    }

    private ActionListener 클릭리스너 = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            차림표버튼 클릭버튼 = (차림표버튼)e.getSource();
            음식 음식 = 클릭버튼.음식얻기();
            boolean 없니 = true;

            //주문내역에 있다면 수량증가.
            for (주문내역 주문 : 주문내역들){
                String 음식이름 = 주문.음식명얻기();

                if (음식이름.equals(음식.음식명받기())) {
                    없니 = false;
                    주문.수량증가();
                    System.out.print(주문.금액얻기());
                    break;
                }
            }
            //주문내역에 추가된게 없으면 라벨생성.
            if (없니){
                추가주문(음식);
            }
        }
    };

    private void 주문테이블(){
        하단위치 = 메뉴판.length/3+2;

        주문내역 목록 = new 주문내역();
            목록.setBounds(버튼_가로, 버튼_세로*하단위치, 300, 20);
            목록.라벨설정(new String[]{"음 식 명","수 량","총 가 격"});
        rowCount++;
        add(목록);
    }

    private void 추가주문(음식 음식){
        주문내역 목록 = new 주문내역();
            목록.setBounds(버튼_가로, 버튼_세로*(하단위치)+20*rowCount, 300, 20);
            목록.라벨설정();
            목록.가격설정(음식.가격받기());
        rowCount++;
        주문내역들.add(목록);
        add(목록);
        목록.라벨채우기(음식.음식명받기());
        //System.out.println(목록.음식명얻기() + 목록.금액얻기());
    }

    public void add(주문내역 목록){
        JLabel[] jl = 목록.라벨얻기();

        for (JLabel j : jl){
            add(j);
        }
    }

    private void 완료취소버튼(){
        JButton 완료 = new JButton("완료");
            완료.setBounds(창크기_가로*7/10 , 창크기_세로*3/5 ,  버튼_가로/2,버튼_세로/2 );
            완료.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });
        JButton 취소 = new JButton("취소");
            취소.setBounds(창크기_가로*7/10 , 창크기_세로*7/10 ,  버튼_가로/2,버튼_세로/2 );
            취소.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });
        add(완료);
        add(취소);
    }

    private void 총금액라벨생성(){
        JLabel 라벨 = new JLabel();
        int 총금액 = 0 ;

        for (주문내역 주문내역:주문내역들){
            총금액 += 주문내역.금액얻기();
        }
        라벨.setText(Integer.toString(총금액));
        //라벨.setBounds();
    }

    private class 차림표버튼 extends JButton{
        private 음식 음식;
        차림표버튼(String s){
            super(s);
        }

        public void 음식설정(음식 음식) {
            this.음식 = 음식;
        }

        public 음식 음식얻기(){
            return 음식;
        }
    }
}