package com.company.quest;
/**
 * Created by Osy on 2017-03-30.
 */
public class Q1 extends Question {
    int x, y;
    public Q1(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public void 정답1() {
        출력("더한 값 ", 덧셈());
        출력("뺀 값 ", 뺄셈());
        출력("곱한 값 ", 곱셈());
        출력("나머지 값 ", 나머지());
    }

    @Override
    public void 정답2() {
        출력("더 큰 값 ", 두수비교());
    }

    public void 숫자입력(int x, int y){
        this.x = x;
        this.y = y;
    }

    int 덧셈(){
        int sum = x + y;
        return sum;
    }

    int 뺄셈(){
        int sub = x - y;
        return sub;
    }

    int 곱셈(){
        int mul = x * y;
        return mul;

    }
    int 나머지(){
        int mod = x % y;
        return mod;
    }

    int 두수비교(){
        int big = x;
        if (x < y){
            big = y;
        }
        return big;
    }

    void 출력(String s,int a){
        System.out.println(s + a);
    }
}