package com.company.quest;

/**
 * Created by seung-yeoloh on 2017. 3. 30..
 */
public abstract class Problem {
    protected int x, y, z;

    public abstract void 정답1();
    public abstract void 정답2();

    public int 덧셈( int x, int y){
        int sum = x + y;
        return sum;
    }

    public int 뺄셈( int x, int y){
        int sub = x - y;
        return sub;
    }

    public int 곱셈(int x, int y){
        int mul = x * y;
        return mul;

    }
    public int 나머지( int x, int y){
        int mod = x % y;
        return mod;
    }

    public int 두수비교(int x, int y){
        int big = x;
        if (x < y){
            big = y;
        }
        return big;
    }
}
