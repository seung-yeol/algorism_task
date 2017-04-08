package com.company.quest;
/**
 * Created by Osy on 2017-03-30.
 */
public class P1 extends Problem {
    public P1(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public void 정답1() {
        System.out.println("더한 값 " + 덧셈( x, y));
        System.out.println("뺀 값 " + 뺄셈( x, y));
        System.out.println("곱한 값 " + 곱셈( x, y));
        System.out.println("나머지 값 " + 나머지( x, y));
    }

    @Override
    public void 정답2() {
        System.out.println("더 큰 값 " + 두수비교( x, y));
    }
}