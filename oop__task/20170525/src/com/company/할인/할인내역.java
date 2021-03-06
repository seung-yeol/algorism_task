package com.company.할인;

import java.util.ArrayList;

/**
 * Created by ce-416-22 on 2017-06-12.
 */
public enum 할인내역 {
    INSTANCE;

    private ArrayList<String> 음식들;
    private ArrayList<Integer> 할인금액들;
    private int 총금액할인율, 총할인기준;

    할인내역(){
        음식들 = new ArrayList();
        할인금액들 = new ArrayList();
        총금액할인율 = 0;
        총할인기준 = 0;
    }

    public static 할인내역 getInstance() {
        return INSTANCE;
    }

    public void 음식할인(String 음식명, int 할인금액){
        if (음식들.indexOf(음식명) == -1){
            음식들.add(음식명);
            할인금액들.add(할인금액);
        }
        else {
            int index = 음식들.indexOf(음식명);
            할인금액들.add(index, 할인금액);
        }
    }

    public void 총금액할인(int 총금액할인율){
        this.총금액할인율 = 총금액할인율;
    }
    public void 총할인기준(int 총할인기준){
        this.총할인기준 = 총할인기준;
    }
    public int 총할인기준얻기(){
        return 총할인기준;
    }

    public int 총할인율얻기(){
        return 총금액할인율;
    }

    public int 음식할인금액얻기(String 음식명){
        try {
            int index = 음식들.indexOf(음식명);

            return 할인금액들.get(index);
        }
        catch (Exception e){
            return 0;
        }
    }
}
