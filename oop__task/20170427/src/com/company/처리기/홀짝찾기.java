package com.company.처리기;

/**
 * Created by ce-416-22 on 2017-04-27.
 */
public class 홀짝찾기 extends 처리기 {
    private int 홀수수, 짝수수;

    public 홀짝찾기(){
        홀수수 = 0;
        짝수수 = 0;
    }

    @Override
    public void 연산() {
        int 나머지;
        for (int i = 0; i < 숫자들.length; i++ ){
            나머지 = 숫자들[i]%2;
            if (나머지 == 0)     짝수수++;
        }
        홀수수 = 숫자들.length - 짝수수;
    }

    @Override
    public void 정답출력() {
        System.out.println("홀수의 수는 : " + 홀수수);
        System.out.println("짝수의 수는 : " + 짝수수);

    }
}