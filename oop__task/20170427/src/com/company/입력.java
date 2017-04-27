package com.company;

import com.company.처리기.*;

import java.util.Scanner;

/**
 * Created by ce-416-22 on 2017-04-27.
 */
public class 입력 {
    private Scanner sc;
    private int 입력수;
    private int[] 숫자들;
    private 처리기 할일;

    public 입력(){
        sc = new Scanner(System.in);
    }

    public void 몇개입력(){
        System.out.print("몇개 입력하시겠습니까 : ");
        입력수 = sc.nextInt();
    }

    public void 수입력(){
        숫자들 = new int[입력수];

        System.out.println("숫자를 입력해주세요 : ");
        for (int i = 0; i < 입력수; i++){
            숫자들[i] = sc.nextInt();
        }
    }

    public void 어떤일(){
        System.out.println("1.합 , 2.큰수찾기, 3.홀짝개수, 4.순서대로나열 ");
        switch (sc.nextInt()){
            case 1 :  할일 = new 합처리();  break;
            case 2 :  할일 = new 큰수찾기(); break;
            case 3 :  할일 = new 홀짝찾기(); break;
            case 4 :  할일 = new 순서처리(); break;
        }
    }

    public 처리기 할일은(){
        return 할일;
    }

    public int[] 숫자들얻기(){
        return 숫자들;
    }
}
