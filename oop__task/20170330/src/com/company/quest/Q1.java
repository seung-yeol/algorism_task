package com.company.quest;

import com.company.quest.Question;

/**
 * Created by Osy on 2017-03-30.
 */
public class Q1 extends Question {
    int x , y;

    @Override
    public void 정답1() {
        덧셈();
        뺄셈();
        곱셈();
        나머지();
    }
    @Override
    public void 정답2() {
        두수비교();
    }
    public void 숫자입력(int x, int y){
        this.x = x;
        this.y = y;
    }

    void 덧셈(){
        int sum = x + y;
        System.out.println("두수의 합은 : " + sum);
    }
    void 뺄셈(){
        int sub = x - y;
        System.out.println("두수의 차는 : " + sub);

    }
    void 곱셈(){
        int mul = x * y;
        System.out.println("두수의 곱은 : " + mul);

    }
    void 나머지(){
        int mod = x % y;
        System.out.println("두수의 나눗셈의 나머지는 : " + mod);
    }

    void 두수비교(){
        System.out.print("더 큰수는 : ");
        if (x < y){
            System.out.println( y );
        }
        else {
            System.out.println( x );
        }
    }
}