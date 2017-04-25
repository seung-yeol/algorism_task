package com.company;

/**
 * Created by ce-416-16 on 2017-04-12.
 */
public class 처리기 {
    private int 총가격;
    private int x, y;

    public void 음식설정(int 정식, int 갈비탕, int 비빔밥){
        총가격 = 정식*9000 + 갈비탕*7000 + 비빔밥*6000;
    }

    public void 숫자설정(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int get총가격(){
        return 총가격;
    }

    public int 덧셈(){
        int sum = x + y;
        return sum;
    }

    public int 뺄셈(){
        int sub = x - y;
        return sub;
    }

    public int 곱셈(){
        int mul = x * y;
        return mul;

    }
    public int 나머지(){
        int mod = x % y;
        return mod;
    }

    public int 두수비교(){
        int big = x;
        if (x < y){
            big = y;
        }
        return big;
    }
}
