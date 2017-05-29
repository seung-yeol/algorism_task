package com.company;

import javax.swing.*;
import java.awt.*;

public class 주문내역 {
    private int x, y;
    private int 가로,세로;
    private JLabel[] 라벨들;
    private String 음식명;
    private int 수량, 가격, 총금액;

    private final int column = 3;

    public 주문내역() {
        라벨들 = new JLabel[column];
        수량 = 1;
    }

    public void setBounds(int x, int y, int 가로, int 세로){
        this.x = x;
        this.y = y;
        this.가로 = 가로/column;
        this.세로 = 세로;
    }

    public void 라벨설정(String[] s){
        for (int i = 0 ; i < column; i++){
            라벨세부설정(i);
            라벨들[i].setText(s[i]);
        }
    }
    public void 라벨설정(){
        for (int i = 0 ; i < column; i++){
           라벨세부설정(i);
        }
    }
    private void 라벨세부설정(int i){
        라벨들[i] = new JLabel();
        라벨들[i].setBounds(x + (가로*i), y, 가로, 세로);
        if (i != 0){    //우측정렬
            라벨들[i].setHorizontalAlignment(SwingConstants.RIGHT);
        }
    }

    public void 가격설정(int 가격){
        this.가격 = 가격;
        총금액 = 수량 * 가격;
    }

    //add이후 setText해야 폼에 글씨가 바로생김 왜그런지는 잘..;
    //그전에는 창을 늘리거나 키워야 생김
    public void 라벨채우기(String 음식명) {
        this.음식명 = 음식명;
        라벨들[0].setText(음식명);
        라벨들[1].setText(Integer.toString(수량));
        라벨들[2].setText(Integer.toString(총금액));
    }

    public String 음식명얻기(){
       return 음식명;
    }
    public int 수량얻기(){
        return 수량;
    }
    public int 금액얻기(){
        return 총금액;
    }

    private void 수량변경(){
        라벨들[1].setText(Integer.toString(수량));
        라벨들[2].setText(Integer.toString(총금액));
    }
    public void 수량감소(){
        수량--;
        총금액 = 수량 * 가격;
        수량변경();
    }
    public void 수량증가(){
        수량++;
        총금액 = 수량 * 가격;
        수량변경();
    }

    public void add(Dialog dialog){
        for (JLabel j : 라벨들){
            dialog.add(j);
        }
    }
}