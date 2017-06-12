package com.company.메뉴;

/**
 * Created by ce-416-28 on 2017-05-11.
 */
public enum  메뉴판 {
    INSTANCE;
    private final 음식[] 메뉴판;

    메뉴판(){
        메뉴판 = new 음식[10];

        메뉴판[0] = new 음식("잡채밥",9000);
        메뉴판[1] = new 음식("볶음밥",6000);
        메뉴판[2] = new 음식("정식",6000);
        메뉴판[3] = new 음식("갈비탕",8000);
        메뉴판[4] = new 음식("두루치기",8000);
        메뉴판[5] = new 음식("비빔국수",6000);
        메뉴판[6] = new 음식("고기국수",7000);
        메뉴판[7] = new 음식("순두부찌개",6000);
        메뉴판[8] = new 음식("김영란세트",30000);
        메뉴판[9] = new 음식("패밀리세트",50000);
    }

    public 음식[] 메뉴판얻기(){
        return 메뉴판;
    }

    public 음식 음식얻기(int i){
        return 메뉴판[i-1];
    }

    public static 메뉴판 getInstance() {
        return INSTANCE;
    }
}