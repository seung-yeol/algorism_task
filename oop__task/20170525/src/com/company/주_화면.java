package com.company;

import com.company.주문대화창.주문내역;
import com.company.주문대화창.주문대화창;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 * Created by Osy on 2017-05-25.
 */
public class 주_화면 extends JFrame {
    public static void main(String[] args) {
        new 주_화면("식당 프로그램");
    }

    private final int 창크기_가로 = 1400;
    private final int 창크기_세로 = 800;
    private final int 버튼_가로 = 창크기_가로/5;
    private final int 버튼_세로 = 창크기_세로/5;
    private final JFrame THIS = this;

    private 좌석버튼 클릭된버튼;

        //JLabel ss = new JLabel("<html>이게<br>라벨 두줄이상 쓰는방법<br></html>");

    주_화면(String title){
        super(title);
        setSize(창크기_가로, 창크기_세로);
        setVisible(true);
        setLayout(null);

        좌석생성();
        주문계산버튼();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    private void 주문계산버튼(){
        JButton 주문버튼 = new JButton("주문");
        주문버튼.setBounds(창크기_가로*9/10,창크기_세로*1/5,70,70);
        JButton 계산버튼 = new JButton("계산");
        계산버튼.setBounds(창크기_가로*9/10,창크기_세로*2/3,70,70);
        add(주문버튼);
        add(계산버튼);

        주문버튼.addActionListener(주문리스너);
    }

    private void 좌석생성(){
        int 좌석수 = 9;

        좌석버튼[] 테이블 = new 좌석버튼[좌석수];

        for (int i = 0; i < 좌석수 ; i++){

            int 열 = i/3 +1;
            int 행 = i%3 +1;

            테이블[i] = new 좌석버튼(Integer.toString(i+1));
            테이블[i].setBounds(버튼_가로 * 행, 버튼_세로 * 열, 버튼_가로-20, 버튼_세로-20);
            테이블[i].setBackground(Color.WHITE);
            테이블[i].addActionListener(테이블클릭리스너);
            add(테이블[i]);
        }
    }

    //주문 다이얼로그로부터 주문내역 얻어오는 메소드
    public void 주문내역얻기(ArrayList<주문내역> 주문내역들){
        클릭된버튼.주문내역들설정(주문내역들);
        String s = "<html>" ;
        for (주문내역 주문 : 주문내역들){
            s += 주문.음식명얻기() + " " + 주문.수량얻기() + "<br>";
        }
        s += "</html>";
        클릭된버튼.setText(s);
    }

    private ActionListener 테이블클릭리스너 = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            if (클릭된버튼 == null){
                클릭된버튼 = (좌석버튼)e.getSource();
                클릭된버튼.setBackground(Color.ORANGE);
            }
            else if (!클릭된버튼.equals(e.getSource())){
                클릭된버튼.setBackground(Color.WHITE);

                클릭된버튼 = (좌석버튼)e.getSource();
                클릭된버튼.setBackground(Color.ORANGE);
            }
            else if (클릭된버튼.getBackground().equals(Color.ORANGE)){
                클릭된버튼.setBackground(Color.WHITE);
            }
            else {
                클릭된버튼.setBackground(Color.ORANGE);
            }
        }
    };
    private ActionListener 주문리스너 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (클릭된버튼.getBackground().equals(Color.ORANGE)){
                클릭된버튼.setBackground(Color.WHITE);

                ArrayList<주문내역> 주문내역들 = 클릭된버튼.주문내역들얻기();
                주문대화창 주문 = new 주문대화창(THIS, "주문", 주문내역들);
                주문.setVisible(true);
            }
        }
    };

    private class 좌석버튼 extends JButton{
        ArrayList<주문내역> 주문내역들;

        private 좌석버튼(String s){
            super(s);
        }

        private void 주문내역들설정(ArrayList<주문내역> 주문내역들) {
            this.주문내역들 = 주문내역들;
        }

        private ArrayList 주문내역들얻기() {
            return 주문내역들;
        }
    }
}