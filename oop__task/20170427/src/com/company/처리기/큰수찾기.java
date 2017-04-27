package com.company.처리기;

/**
 * Created by ce-416-22 on 2017-04-27.
 */
public class 큰수찾기 extends 처리기 {
    private int 큰수;

    public 큰수찾기(){
        큰수 = 0;
    }

    @Override
    public void 연산() {
        큰수 = 숫자들[0];
        for (int i = 1; i < 숫자들.length; i++ ){
            if (큰수 < 숫자들[i]) 큰수 = 숫자들[i];
        }
    }

    @Override
    public void 출력() {
        System.out.println("가장 큰수는 : " + 큰수);
    }
}