package com.company;

import com.company.메뉴.음식공장;

/**
 * Created by ce-416-28 on 2017-05-11.
 */
public class 처리기 {
    private int 수량, 가격, 총가격;

    public void 값받자(음식공장 음식, int 수량){
        this.가격 = 음식.가격받기();
        this.수량 = 수량;
    }

    public void 계산(){
        총가격 = 가격*수량;
    }

    public int 총가격은(){
        return 총가격;
    }
}
