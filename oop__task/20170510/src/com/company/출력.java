package com.company;

import com.company.메뉴.음식공장;

/**
 * Created by ce-416-28 on 2017-05-11.
 */
public class 출력 {
    private String  음식명;
    private int 수량;
    private int 총가격;

    public void 값받자(음식공장 음식, int 수량, int 총가격){
        음식명 = 음식.음식명받기();
        this.수량 = 수량;
        this.총가격 = 총가격;
    }

    public void 출력(){
        System.out.println("주문하신 음식은 "+ 음식명 +"이고 수량은 "
                + 수량 + "개 이고 총가격은 " + 총가격 +"원 입니다" );
    }
}
