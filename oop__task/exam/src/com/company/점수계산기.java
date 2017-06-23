package com.company;

/**
 * Created by Osy on 2017-06-23.
 */
public class 점수계산기 {
    private static 점수계산기 INSTANCE;
    private float 총점;
    private 점수계산기(){
        총점 = 0;
    }

    public static 점수계산기 getInstance() {
        if (INSTANCE == null){
            INSTANCE = new 점수계산기();
        }
        return INSTANCE;
    }
    public 점수계산기 계산추가(int 점수, int 비율){
        총점 += (float)점수*(float)비율/100;
        return this;
    }
    public int 계산값받기(){
        int 계산값 = (int)총점;
        총점 = 0;

        return 계산값;
    }
}
