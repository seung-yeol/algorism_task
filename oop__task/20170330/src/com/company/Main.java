package com.company;

import com.company.quest.Q1;
import com.company.quest.Q2;
import com.company.quest.Question;

import java.util.Scanner;

public class Main {
    Scanner sc;
    public static void main(String[] args) {
        Main m = new Main();
        m.첫번째문제();
        m.두번째문제();
    }
    void 첫번째문제(){
        sc = new Scanner(System.in);
        System.out.println("숫자 두개를 입력해주세요");
        int x = sc.nextInt();
        int y = sc.nextInt();

        답( new Q1( x, y));
    }
    void 두번째문제(){
        System.out.println("숫자 세개를 입력해주세요");
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();

        답( new Q2( x, y, z));
    }
    void 답(Question question){
        question.정답1();
        question.정답2();
    }
}