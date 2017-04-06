package com.company.quest;

/**
 * Created by seung-yeoloh on 2017. 4. 6..
 */
public class 중간값은 {
    private int 절대값;
    private int 중간값;

    중간값은(int x, int y, int z){
        중간값 = x;
        절대값 = Math.abs(y - z);
    }

    public int 에요_중간값() {
        return 중간값;
    }

    public int get절대값(){
        return 절대값;
    }
}