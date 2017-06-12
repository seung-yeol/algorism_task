package com.company.메뉴;

/**
 * Created by ce-416-28 on 2017-05-11.
 */
public class 음식 {
    private String 음식명;
    private int 가격;

    public 음식(String 음식명, int 가격){
        this.음식명 = 음식명;
        this.가격 = 가격;
    }

    public String 음식명받기(){
        return 음식명;
    }

    public int 가격받기(){
        return 가격;
    }
}
