package com.company;

/**
 * Created by ce-416-16 on 2017-04-12.
 */
public class 출력 {
    private int 정식, 갈비탕, 비빔밥;
    private int x, y, 합, 뺌, 곱, 나머지, 큰;
    private int 총가격 = 0;

    public 출력(int 정식, int 갈비탕, int 비빔밥, int 총가격){
        this.정식 = 정식;
        this.갈비탕 = 갈비탕;
        this.비빔밥 = 비빔밥;
        this.총가격 = 총가격;
    }

    public 출력(int x, int y, int 합, int 뺌, int 곱, int 나머지, int 큰){
        this.x = x;
        this.y = y;
        this.합 = 합;
        this.뺌 = 뺌;
        this.곱 = 곱;
        this.나머지 = 나머지;
        this.큰 = 큰;
    }

    public void 입력값출력(){
        System.out.println("입력값은 : " + x + ", " + y );
    }

    public void 사칙연산(){
        System.out.println("합값은 : " + 합 );
        System.out.println("뺄셈값은 : " + 뺌 );
        System.out.println("곱한값은 : " + 곱 );
        System.out.println("나머지값은 : " + 나머지 );
    }
    public void 큰값출력(){
        System.out.println("더 큰값은 : " + 큰);
    }

    public void 메뉴출력(){
        System.out.println("정식, 갈비탕, 비빔밥의 수는 각각" +
                         정식 +" "+ 갈비탕 +" "+ 비빔밥 +" "+"입니다");
    }

    public void 총가격출력(){
        System.out.println("총 가격은 " + 총가격 + " 입니다");
    }
}
