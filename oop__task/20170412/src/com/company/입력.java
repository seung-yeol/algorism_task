package com.company;

import java.util.Scanner;

/**
 * Created by ce-416-16 on 2017-04-12.
 */
public class 입력 {
    private int 정식, 갈비탕, 비빔밥;
    private int x, y;
    private Scanner sc;

    public 입력(){
        sc = new Scanner(System.in);
    }

    public void 메뉴입력(){
        정식 = sc.nextInt();
        갈비탕 = sc.nextInt();
        비빔밥 = sc.nextInt();
    }

    public void 숫자입력(){
        x = sc.nextInt();
        y = sc.nextInt();
    }

    public int 정식수(){
        return 정식;
    }

    public int 갈비탕수(){
        return 갈비탕;
    }

    public int 비빔밥수(){
        return 비빔밥;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
