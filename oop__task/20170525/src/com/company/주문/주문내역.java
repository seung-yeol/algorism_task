package com.company.주문;

import com.company.금액계산기;
import com.company.메뉴.음식;

public class 주문내역 {
    private 음식 음식;
    private String 음식명;
    private int 수량, 가격, 총금액;

    public 주문내역(음식 음식) {
        this.음식 = 음식;
        this.음식명 = 음식.음식명받기();
        this.가격 = 금액계산기.음식할인적용(음식명, 음식.가격받기());
        수량 = 1;
        총금액 = 수량 * 가격;
    }

    public void 수량감소(){
        수량--;
        총금액 = 수량 * 가격;
    }
    public void 수량증가(){
        수량++;
        총금액 = 수량 * 가격;
    }

    public String 음식명얻기(){
       return 음식명;
    }
    public int 수량얻기(){
        return 수량;
    }
    public int 가격얻기(){
        return 음식.가격받기();
    }
    public int 총금액얻기(){
        return 총금액;
    }
}