package com.company.quest;

/**
 * Created by Osy on 2017-03-30.
 */
public class P2 extends Problem {
    private int 첫, 둘, 셋;

    public P2(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        숫자정렬(x, y, z);
    }

    @Override
    public void 정답1() {
        System.out.print("큰 순서대로 나열 : ");
        System.out.println(첫 + "\t" + 둘 + "\t" + 셋 + "\t");
    }

    @Override
    public void 정답2() {
        System.out.println("가운데 값은 " + 중간값());
    }

    private void 숫자정렬(int 첫, int 둘, int 셋){     //삽입정렬원리
        int tmp;
        if (첫 < 둘){
            tmp = 첫;
            첫 = 둘;
            둘 = tmp;
        }
        if (둘 < 셋) {
            tmp = 둘;
            둘 = 셋;
            셋 = tmp;
            if (첫 < 둘){
                tmp = 첫;
                첫 = 둘;
                둘 = tmp;
            }
        }

        this.첫 = 첫;
        this.둘 = 둘;
        this.셋 = 셋;
    }

    private int 중간값(){
        중간값은 X, Y, Z;

        X = new 중간값은(x, y, z);
        Y = new 중간값은(y, z, x);
        Z = new 중간값은(z, x, y);

        중간값은 이거 = X;
        if (이거.get절대값() < Y.get절대값()){
            이거 = Y;
        }
        if (이거.get절대값() < Z.get절대값()){
            이거 = Z;
        }

        return 이거.에요_중간값();
    }
}