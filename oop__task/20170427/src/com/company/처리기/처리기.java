package com.company.처리기;

/**
 * Created by ce-416-22 on 2017-04-27.
 */
public abstract class 처리기 {
    protected int[] 숫자들;

    public abstract void 연산();

    public abstract void 정답출력();

    public void 수넣기(int[] 숫자들){
        this.숫자들 = 숫자들;
    }

    public void 숫자들출력(){
        System.out.print("입력하신 숫자는 : ");
        for (int i = 숫자들.length-1 ; i >= 0 ; i--){
            System.out.print(숫자들[i] + " ");
        }
        System.out.println("입니다 ");
    }
}
