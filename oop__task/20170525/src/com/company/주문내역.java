package com.company;

import javax.swing.*;

public class 주문내역 {
    private int column;
    private int width, length;
    private int x, y;
    private JLabel[] rows;

    public 주문내역(int column) {
        this.column = column;
        rows = new JLabel[column];
    }

    public void setBounds(int x, int y, int width, int length){
        this.x = x;
        this.y = y;
        this.width = width;
        this.length = length;
    }

    public void setRow(String[] s){
        int rowWidth = width/column;

        for (int i = 0 ; i < column; i++){
            rows[i] = new JLabel();
            rows[i].setText(s[i]);
            rows[i].setBounds(x+(rowWidth*i), y, rowWidth, length);
        }
    }

    public JLabel[] getRow(){
        return rows;
    }

    public int getColumn(){
        return column;
    }
}
