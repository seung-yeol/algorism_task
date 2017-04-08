package com.company;

import com.company.quest.P1;
import com.company.quest.P2;
import com.company.quest.Problem;

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

        답( new P1( x, y));
    }
    void 두번째문제(){
        sc = new Scanner(System.in);
        System.out.println("숫자 세개를 입력해주세요");
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();

        답( new P2( x, y, z));
    }
    void 답(Problem problem){
        problem.정답1();
        problem.정답2();
    }
}