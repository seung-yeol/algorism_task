package com.company;

import javax.swing.*;

public class 주문내역 {
    private int column;
    private int width, length;
    private int x, y;
    private JLabel[] rows;
    private int amount;

    public 주문내역(int column) {
        this.column = column;
        rows = new JLabel[column];
        amount = 1;
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

    public void setRow(String s){
        int rowWidth = width/column;

        rows[0] = new JLabel();
        rows[1] = new JLabel();
        rows[2] = new JLabel();

        for (int i = 0 ; i < column; i++){
            rows[i].setBounds(x+(rowWidth*i), y, rowWidth, length);
        }

        rows[0].setText(s);
        rows[1].setText(Integer.toString(amount));
        rows[2].setText("총가격");

    }

    public JLabel[] getRow(){
        return rows;
    }

    public JLabel getFoodName(){
        return rows[0];
    }
    public JLabel getAmountLabel(){
        return rows[1];
    }
    public JLabel getPrice(){
        return rows[2];
    }

    public int getColumn(){
        return column;
    }

    private void changeAmount(){
        rows[1].setText(Integer.toString(amount));
    }

    public void minusAmount(){
        amount--;
        changeAmount();
    }

    public void plusAmount(){
        amount++;
        changeAmount();
    }
}