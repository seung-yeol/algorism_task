package com.company.quest;

/**
 * Created by Osy on 2017-03-30.
 */
public class Q2 extends Question {
    int x, y, z;
    int[] array;

    @Override
    public void 정답1() {
        순서대로();
    }
    @Override
    public void 정답2() {
        두번째큰거();
    }
    public void 숫자입력(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
        숫자정렬();
    }
    void 숫자정렬(){        //삽입정렬을 이용한 숫자정렬
        array = new int[]{ x, y, z};

        for (int i = 1; i < 3; i++) {
            int 정렬대상 = array[i];
            int 비교대상 = i - 1;

            while (비교대상 >= 0 && 정렬대상 < array[비교대상]) {
                array[비교대상+1] = array[비교대상];
                비교대상--;
            }
            array[비교대상 + 1] = 정렬대상;
        }
    }
    void 순서대로(){
        System.out.print("큰 순서대로 나열 : ");
        System.out.println(array[0] + "\t" + array[1] + "\t"
                + array[2] + "\t");

    }
    void 두번째큰거(){
        System.out.print("두번째 값 : ");
        System.out.println(array[1]);
    }
}