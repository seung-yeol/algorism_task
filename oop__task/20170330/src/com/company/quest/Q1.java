package com.company.quest;
/**
 * Created by Osy on 2017-03-30.
 */
public class Q1 extends Question {
    private int x, y;

    public Q1(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public void 정답1() {
        System.out.println("더한 값 " + 덧셈());
        System.out.println("뺀 값 " + 뺄셈());
        System.out.println("곱한 값 " + 곱셈());
        System.out.println("나머지 값 " + 나머지());
    }

    @Override
    public void 정답2() {
        System.out.println("더 큰 값 " + 두수비교());
    }

    private int 덧셈(){
        int sum = x + y;
        return sum;
    }

    private int 뺄셈(){
        int sub = x - y;
        return sub;
    }

    private int 곱셈(){
        int mul = x * y;
        return mul;

    }
    private int 나머지(){
        int mod = x % y;
        return mod;
    }

    private int 두수비교(){
        int big = x;
        if (x < y){
            big = y;
        }
        return big;
    }
}