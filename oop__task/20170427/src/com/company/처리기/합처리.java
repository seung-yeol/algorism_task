package com.company.처리기;

public class 합처리 extends 처리기 {
    private int 합;

    public 합처리(){
        합 = 0;
    }

    @Override
    public void 연산() {
        for (int i = 0; i < 숫자들.length; i++ ){
            합 += 숫자들[i];
        }
    }

    @Override
    public void 출력() {
        System.out.println("입력하신 값들의 합은 : " +합);
    }
}