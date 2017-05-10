package com.company;

import com.company.메뉴.음식공장;

public class 제어자 {

    public static void main(String[] args) {
	    제어자 m = new 제어자();
	    m.주_실행();
    }

    public void 주_실행(){
        음식공장 음식;
        int 수량, 총가격;

        입력 입력 = new 입력();
        입력.메뉴입력();
        음식 = 입력.메뉴출력();
        수량 = 입력.수량출력();

        처리기 처리기 = new 처리기();
        처리기.값받자(음식,수량);
        처리기.계산();
        총가격 = 처리기.총가격은();

        출력 출력 = new 출력();
        출력.값받자(음식, 수량, 총가격);
        출력.출력();
    }
}