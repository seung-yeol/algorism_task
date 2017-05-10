package com.company;

import com.company.메뉴.메뉴판;
import com.company.메뉴.음식공장;

import java.util.Scanner;

/**
 * Created by ce-416-28 on 2017-05-11.
 */
public class 입력 {
    private Scanner sc;
    private com.company.메뉴.메뉴판 메뉴판;
    private 음식공장 음식;
    private int 번호, 수량;

    public 입력(){
        sc = new Scanner(System.in);
        메뉴판 = new 메뉴판();
    }

    public void 메뉴입력(){
        System.out.println("메뉴판을 보고 원하는 음식을 선택해주세요");
        메뉴판.메뉴출력();

        System.out.print("원하시는 메뉴는 : ");
        번호 = sc.nextInt();

        System.out.print("몇개 주문하실건가요 : ");
        수량 = sc.nextInt();
    }

    public 음식공장 메뉴출력(){
        음식 = 메뉴판.음식얻기(번호);
        return 음식;
    }

    public int 수량출력(){
        return 수량;
    }
}