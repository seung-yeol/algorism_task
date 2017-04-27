package com.company;

import com.company.처리기.처리기;

public class 제어기 {
    public static void main(String[] args) {
        제어기 m = new 제어기();
        m.주_처리();
    }
    public void 주_처리(){
        입력 입력 = new 입력();
        입력.몇개입력();
        입력.수입력();
        입력.어떤일();
        int[] 숫자들 = 입력.숫자들얻기();

        처리기 할일 = 입력.할일은();
        할일.수넣기(숫자들);
        할일.연산();
        할일.숫자들출력();
        할일.정답출력();
    }
}
