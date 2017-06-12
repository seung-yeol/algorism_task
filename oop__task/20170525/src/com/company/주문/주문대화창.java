package com.company.주문;

import com.company.메뉴.메뉴판;
import com.company.메뉴.음식;
import com.company.주_화면;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Created by Osy on 2017-05-25.
 */
public class 주문대화창 extends JDialog{
    private final int 창크기_가로 = 800;
    private final int 창크기_세로 = 800;
    private final int 버튼_가로 = 창크기_가로/5;
    private final int 버튼_세로 = 창크기_세로/10;
    private final JDialog THIS = this;

    private int 하단위치;
    private int rowCount;   //위치를 위한
    private JLabel 금액라벨;
    private ArrayList<주문내역> 주문내역들;
    private ArrayList<주문라벨> 주문라벨들;

    public 주문대화창(JFrame owner, String title, ArrayList 주문내역들) {
        super(owner, title);
        if (주문내역들 != null){
            this.주문내역들 = 주문내역들;
        }
        else {
            this.주문내역들 = new ArrayList();
        }
        주문라벨들 = new ArrayList();
        rowCount = 1;

        setSize(창크기_가로,창크기_세로);
        setLayout(null);

        메뉴판생성();
        주문라벨생성();
        원주문();
        완료취소버튼();
        금액라벨생성();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    private void 메뉴판생성(){
        메뉴판 메뉴 = new 메뉴판();
        음식[] 메뉴판 = 메뉴.메뉴판얻기();
        하단위치 = 메뉴판.length/3+2;

        int 메뉴수 = 메뉴판.length;
        차림표버튼[] 음식증가 = new 차림표버튼[메뉴수];
        차림표버튼[] 음식감소 = new 차림표버튼[메뉴수];

        for (int i = 0; i < 메뉴수 ; i++){
            String btnStr = 메뉴판[i].음식명받기();
            int 열 = i/3 +1;
            int 행 = i%3 +1;

            음식증가[i] = new 차림표버튼(btnStr);
                음식증가[i].setBounds(버튼_가로 * 행, 버튼_세로 * 열, 버튼_가로-60, 버튼_세로-20);
                음식증가[i].addActionListener(차림표증가리스너);
                음식증가[i].음식설정(메뉴판[i]);
            add(음식증가[i]);

            음식감소[i] = new 차림표버튼("↓");
                음식감소[i].setBounds(버튼_가로 * 행 +버튼_가로-60, 버튼_세로 * 열, 50, 버튼_세로-20);
                음식감소[i].addActionListener(차림표감소리스너);
                음식감소[i].음식설정(메뉴판[i]);
            add(음식감소[i]);
        }
    }

    private void 주문라벨생성(){
        주문라벨 주문라벨 = new 주문라벨();
            주문라벨.setBounds(버튼_가로, 버튼_세로*하단위치, 300, 20);
            주문라벨.라벨채우기(new String[]{"음 식 명","수 량","가 격"});
        주문라벨.라벨들붙이기();
    }
    private void 원주문(){
        if (주문내역들.isEmpty() == false){
            for (주문내역 주문내역 : 주문내역들){
                주문라벨 주문라벨 = new 주문라벨(주문내역);
                주문라벨.setBounds(버튼_가로, 버튼_세로*(하단위치)+20*rowCount, 300, 20);
                주문라벨.라벨채우기();
                주문라벨.라벨들붙이기();

                rowCount++;
                주문라벨들.add(주문라벨);
            }
        }
    }
    private void 추가주문(음식 음식){
        주문내역 주문내역 = new 주문내역(음식);
        주문내역들.add(주문내역);

        주문라벨 주문라벨 = new 주문라벨(주문내역);
            주문라벨.setBounds(버튼_가로, 버튼_세로*(하단위치)+20*rowCount, 300, 20);
            주문라벨.라벨채우기();
            주문라벨.라벨들붙이기();
        주문라벨들.add(주문라벨);

        rowCount++;
    }
    private void 주문들변경(){
        for (int i = 0 ; i < 주문내역들.size(); i++){
            주문라벨들.get(i).setLocation(버튼_가로, 버튼_세로*(하단위치)+20*(i+1));
        }
    }

    private void 완료취소버튼(){
        JButton 완료 = new JButton("완료");
            완료.setBounds(창크기_가로*7/10 , 창크기_세로*3/5 ,  버튼_가로/2,버튼_세로/2 );
            완료.addActionListener(완료취소리스너);
        JButton 취소 = new JButton("취소");
            취소.setBounds(창크기_가로*7/10 , 창크기_세로*7/10 ,  버튼_가로/2,버튼_세로/2 );
            취소.addActionListener(완료취소리스너);
        add(완료);
        add(취소);
    }

    private void 금액라벨생성(){
        금액라벨 = new JLabel("0");
        금액라벨.setHorizontalAlignment(SwingConstants.RIGHT);
        금액라벨.setBounds(버튼_가로, 버튼_세로*(하단위치)+20*(rowCount), 300, 20);
        add(금액라벨);
        금액라벨변경();
    }
    private void 금액라벨변경(){
        int 총금액 = 0 ;

        for (주문내역 주문내역:주문내역들){
            총금액 += 주문내역.총금액얻기();
        }
        금액라벨.setLocation(버튼_가로, 버튼_세로*(하단위치)+20*(rowCount));
        금액라벨.setText(Integer.toString(총금액));
    }

    private ActionListener 차림표증가리스너 = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            e.getActionCommand();
            차림표버튼 클릭버튼 = (차림표버튼)e.getSource();
            음식 음식 = 클릭버튼.음식얻기();
            boolean 없니 = true;

            //주문내역에 있다면 수량증가.
            for (주문라벨 주문라벨 : 주문라벨들){
                String 음식이름 = 주문라벨.주문내역.음식명얻기();

                if (음식이름.equals(음식.음식명받기())) {
                    없니 = false;
                    주문라벨.주문내역.수량증가();
                    주문라벨.수량변경();
                    break;
                }
            }

            //주문내역에 추가된게 없으면 라벨생성.
            if (없니){
                추가주문(음식);
            }
            금액라벨변경();
        }
    };
    private ActionListener 차림표감소리스너 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            차림표버튼 클릭버튼 = (차림표버튼)e.getSource();
            음식 음식 = 클릭버튼.음식얻기();

            //주문내역에 있다면 수량증가.
            for (주문라벨 주문라벨 : 주문라벨들){
                String 음식이름 = 주문라벨.주문내역.음식명얻기();

                if (음식이름.equals(음식.음식명받기())) {

                    주문라벨.주문내역.수량감소();
                    주문라벨.수량변경();

                    if (주문라벨.주문내역.수량얻기() == 0){
                        주문라벨.라벨들삭제();

                        주문내역들.remove(주문라벨.주문내역);
                        주문라벨들.remove(주문라벨);
                        rowCount--;
                    }
                    break;
                }
            }
            주문들변경();
            금액라벨변경();
        }
    };
    private ActionListener 완료취소리스너 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("완료")){
                주_화면 주 = (주_화면)getParent();
                주.주문내역설정(주문내역들);
                dispose();
            }
            else {
                dispose();
            }
        }
    };

    private class 차림표버튼 extends JButton{
        private 음식 음식;
        차림표버튼(String s){
            super(s);
        }

        private void 음식설정(음식 음식) {
            this.음식 = 음식;
        }

        private 음식 음식얻기(){
            return 음식;
        }
    }

    private class 주문라벨{
        private final int column = 3;

        private int 가로;
        private 주문내역 주문내역;
        private JLabel[] 라벨들;

        private 주문라벨() {
            라벨들 = new JLabel[column];

            for (int i = 0; i < column ; i++){
                라벨들[i] = new JLabel();
            }
        }
        private 주문라벨(주문내역 주문내역){
            라벨들 = new JLabel[column];
            this.주문내역 = 주문내역;

            for (int i = 0; i < column ; i++){
                라벨들[i] = new JLabel();
            }
        }

        private void setBounds(int x, int y, int 가로, int 세로){
            this.가로 = 가로/column;

            for (int i = 0 ; i < column; i++){
                라벨들[i].setBounds(x + (this.가로*i), y, this.가로, 세로);
                if (i != 0){    //우측정렬
                    라벨들[i].setHorizontalAlignment(SwingConstants.RIGHT);
                }
            }
        }
        private void setLocation(int x, int y){
            for (int i = 0; i < column ; i++){
                라벨들[i].setLocation(x + (가로*i), y);
            }
        }

        /*private void 주문내역채우기(String 음식명, int 가격){
            주문내역.음식명설정(음식명);
            주문내역.가격설정(가격);
        }*/
        private void 라벨채우기(String[] s){
            for (int i = 0 ; i < column; i++){
                라벨들[i].setText(s[i]);
            }
        }
        private void 라벨채우기() {
            라벨들[0].setText(주문내역.음식명얻기());
            라벨들[1].setText(Integer.toString(주문내역.수량얻기()));
            라벨들[2].setText(Integer.toString(주문내역.총금액얻기()));
        }

        private void 수량변경(){
            라벨들[1].setText(Integer.toString(주문내역.수량얻기()));
            라벨들[2].setText(Integer.toString(주문내역.총금액얻기()));
        }

        private void 라벨들붙이기(){
            for (JLabel j : 라벨들){
                THIS.add(j);
            }
        }
        private void 라벨들삭제(){
            for (JLabel j : 라벨들){
                THIS.remove(j);
            }
        }
    }
}