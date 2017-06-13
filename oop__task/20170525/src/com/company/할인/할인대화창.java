package com.company.할인;

import com.company.메뉴.메뉴판;
import com.company.메뉴.음식;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 * Created by ce-416-22 on 2017-06-12.
 */
public class 할인대화창 extends JDialog{
    private final int 창크기_가로 = 800;
    private final int 창크기_세로 = 800;
    private final int 라벨_가로 = 창크기_가로/5;
    private final int 라벨_세로 = 창크기_세로/18;
    private final JDialog THIS = this;

    private 할인내역 할인내역;
    private ArrayList<메뉴판라벨> 라벨들;
    private JTextField 할인기준, 할인율;

    public 할인대화창(JFrame frame) {
        super(frame, "할인대화창 창");
        할인내역 = 할인내역.getInstance();
        라벨들 = new ArrayList();

        setSize(창크기_가로,창크기_세로);
        setLayout(null);

        속성();
        메뉴라벨();
        총금액할인라벨();
        완료취소버튼();

        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }
    private void 속성(){
        JLabel 음식명 = new JLabel("음식명");
            음식명.setBounds(100, 라벨_세로 , 라벨_가로, 라벨_세로 -25);
        JLabel 할인금액 = new JLabel("할인금액");
            할인금액.setBounds(100 + 라벨_가로/2, 라벨_세로 , 라벨_가로/2, 라벨_세로 -25);
            할인금액.setHorizontalAlignment(JTextField.CENTER);
        add(음식명);
        add(할인금액);
    }

    private void 메뉴라벨(){
        메뉴판 메뉴 = 메뉴판.getInstance();
        음식[] 메뉴판 = 메뉴.메뉴판얻기();

        for (int i = 0; i < 메뉴판.length; i++){
            메뉴판라벨 라벨 = new 메뉴판라벨(메뉴판[i].음식명받기());
            라벨.setBounds(100, 라벨_세로 * (i+2), 라벨_가로, 라벨_세로 -25);
            라벨.라벨들붙이기();
            라벨들.add(라벨);
        }
    }

    private void 총금액할인라벨(){
        int 가로 = 라벨_가로/2;
        JLabel 기준 = new JLabel("할인기준");
            기준.setBounds(420 + 가로, 라벨_세로 * 2, 가로, 라벨_세로 -25);
            기준.setHorizontalAlignment(JTextField.CENTER);
        JLabel 율 = new JLabel("할인율");
            율.setBounds(440 + 가로 * 2, 라벨_세로 * 2, 가로, 라벨_세로 -25);
            율.setHorizontalAlignment(JTextField.CENTER);
        JLabel 라벨 = new JLabel("총금액할인율");
            라벨.setBounds(400, 라벨_세로 * 3, 가로, 라벨_세로 -25);

        할인기준 = new JTextField("0");
            할인기준.setBounds(420 + 가로, 라벨_세로 * 3, 가로, 라벨_세로 -25);
            할인기준.setHorizontalAlignment(JTextField.RIGHT);
        할인율 = new JTextField("0");
            할인율.setBounds(440 + 가로 * 2, 라벨_세로 * 3, 가로, 라벨_세로 -25);
            할인율.setHorizontalAlignment(JTextField.RIGHT);

        add(기준);
        add(율);
        add(라벨);
        add(할인기준);
        add(할인율);
    }

    private void 완료취소버튼(){
        JButton 완료 = new JButton("완료");
        완료.setBounds(창크기_가로*7/10 , 창크기_세로*3/5 ,  라벨_가로/2,라벨_세로/2 );
        완료.addActionListener(완료리스너);

        JButton 취소 = new JButton("취소");
        취소.setBounds(창크기_가로*7/10 , 창크기_세로*7/10 ,  라벨_가로/2,라벨_세로/2 );
        취소.addActionListener((ActionEvent e) ->{
            dispose();
        });
        add(완료);
        add(취소);
    }

    private ActionListener 완료리스너 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0 ; i < 라벨들.size(); i++){
                할인내역.음식할인(라벨들.get(i).음식명, 라벨들.get(i).할인금액얻기());
            }

            할인내역.총금액할인(Integer.parseInt(할인율.getText()));
            할인내역.총할인기준(Integer.parseInt(할인기준.getText()));
            dispose();
        }
    };

    private class 메뉴판라벨{
        private final int column = 2;

        private int 가로;
        private JLabel 음식라벨;
        private JTextField 할인필드;
        private String 음식명;

        private 메뉴판라벨(String 음식명) {
            this.음식명 = 음식명;
            음식라벨 = new JLabel(음식명);
            할인필드 = new JTextField("0");
            할인필드.setHorizontalAlignment(JTextField.RIGHT);
        }

        private void setBounds(int x, int y, int 가로, int 세로){
            this.가로 = 가로/column;
            음식라벨.setBounds(x , y, this.가로, 세로);
            할인필드.setBounds(x + this.가로, y, this.가로, 세로);
        }

        private void 라벨들붙이기(){
            THIS.add(음식라벨);
            THIS.add(할인필드);
        }
        private int 할인금액얻기(){
            return Integer.parseInt(할인필드.getText());
        }
    }
}