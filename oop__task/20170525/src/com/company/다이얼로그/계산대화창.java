package com.company.다이얼로그;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Osy on 2017-06-01.
 */
public class 계산대화창 extends JDialog {
    private final int 창크기_가로 = 800;
    private final int 창크기_세로 = 800;
    private final int 버튼_가로 = 창크기_가로/5;
    private final int 버튼_세로 = 창크기_세로/10;

    private final 계산대화창 THIS = this;
    private int row;

    private ArrayList<주문내역> 주문내역들;

    public 계산대화창(JFrame owner, String title, ArrayList 주문내역들){
        super(owner, title);

        this.주문내역들 = 주문내역들;
        row = 0;

        setSize(창크기_가로,창크기_세로);
        setLayout(null);

        주문테이블();
        원주문();
    }

    private void 주문테이블(){
        주문내역 목록 = new 주문내역();
        목록.setBounds(버튼_가로, 버튼_세로, 300, 20);
        목록.라벨설정(new String[]{"음 식 명","수 량","가 격"});
        목록.add(THIS);
    }
    private void 원주문(){
        int 총금액 = 0;
        for (주문내역 목록 : 주문내역들){
            String s = 목록.음식명얻기();
            int amount = 목록.수량얻기();
            int price = 목록.금액얻기();

            라벨들(s, amount, price);
            총금액 += price;
        }
    }

    private void 라벨들(String s, int amount, int price){
        JLabel[] jl = new JLabel[3];
        jl[0] = new JLabel(s);
        jl[1] = new JLabel(Integer.toString(amount));
        jl[2] = new JLabel(Integer.toString(price));

        for (int i = 0; i < 3 ; i++){
            jl[i].setBounds(버튼_가로*(i+1), 버튼_세로+20*(1+row), 100, 20);
            if (i != 0){
                jl[i].setHorizontalAlignment(SwingConstants.RIGHT);
            }
            add(jl[i]);
        }
        row++;

    }
}
