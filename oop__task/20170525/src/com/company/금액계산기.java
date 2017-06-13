package com.company;

import com.company.할인.할인내역;

/**
 * Created by sy on 2017-06-13.
 */
public final class 금액계산기 {
    private static 할인내역 할인 = 할인내역.getInstance();
    private 금액계산기(){}

    public static int 음식할인적용(String 음식명, int 원가){
        int 할인가 =  할인.음식할인금액얻기(음식명);
        return 원가 - 할인가;
    }

    public static int 총금액할인적용(int 총금액){
        int 할인기준 = 할인.getInstance().총할인기준얻기();
        int 할인율 = 할인.getInstance().총할인율얻기();

        if (총금액 >= 할인기준){
            총금액 = 총금액 * (100-할인율) /100;
        }
        return 총금액;
    }
}
