package com.company.할인;

import com.company.메뉴.음식;

import java.util.ArrayList;

/**
 * Created by ce-416-22 on 2017-06-12.
 */
public enum 할인내역 {
    INSTANCE;

    private ArrayList<String> 음식들;
    private ArrayList<Integer> 할인금액들;
    private int 총금액할인율;

    public static 할인내역 getInstance() {
        return INSTANCE;
    }

    public void 음식할인(String 음식명, int 할인금액){
        음식들.add(음식명);
        할인금액들.add(할인금액);
    }

    public void 총금액할인(int 총금액할인율){
        this.총금액할인율 = 총금액할인율;
    }

    public int 총할인율얻기(){
        return 총금액할인율;
    }

    public int 음식할인금액얻기(String 음식명){
        try {
            int index = 음식들.indexOf(음식명);

            return 할인금액들.get(index);
        }
        catch (NullPointerException e){
            return 0;
        }
    }
}
