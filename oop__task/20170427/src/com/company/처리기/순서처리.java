package com.company.처리기;

/**
 * Created by ce-416-22 on 2017-04-27.
 */
public class 순서처리 extends 처리기 {
    int[] 정렬용;

    @Override
    public void 연산(){
        배열복사();
        삽입정렬();
    }

    @Override
    public void 정답출력() {
        System.out.println("큰순서대로 정답출력");
        for (int i = 정렬용.length-1; i >= 0 ; i--){
            System.out.print(i + " ");
        }
    }

    private void 배열복사(){
        정렬용 = new int[숫자들.length];
        for (int i = 0; i < 숫자들.length; i++ ) {
            정렬용[i] = 숫자들[i];
        }
    }

    private void 삽입정렬(){    //삽입정렬이용 순서처리
        int tmp, 비교대상;

        for(int 위치 = 1; 위치 < 정렬용.length; 위치++){
            tmp = 정렬용[위치];
            for(비교대상 = 위치-1; 비교대상 >= 0; 비교대상--){
                if (tmp < 정렬용[비교대상]){
                    정렬용[비교대상+1] = 정렬용[비교대상];
                }
                else {
                    break;
                }
            }
            정렬용[비교대상+1] = tmp;
        }
    }
}