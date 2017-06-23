package com.company;

import java.util.ArrayList;

/**
 * Created by ce-416-24 on 2017-06-21.
 */
public class 학생데이터 {
    private static 학생데이터 Instance;

    private ArrayList<String[]> 정보들 = new ArrayList();
    private int 중간비율, 기말비율, 출석비율, 과제비율;
    private int[] 학점점수;

    private 학생데이터(){
        중간비율 = 30;
        기말비율 = 30;
        출석비율 = 10;
        과제비율 = 30;

        학점점수 = new int[]{97, 94, 90, 87, 84, 80, 77, 74, 70, 67, 64, 60};
    }

    public static 학생데이터 getInstance() {
        if (Instance == null){
            Instance = new 학생데이터();
        }
        return Instance;
    }

    public void 정보얻기(ArrayList<String[]> 정보들){
        this.정보들 = 정보들;

        학점총점계산();
    }

    public void 학점총점계산(){
        for (String[] s: 정보들){
            int 총점;
            try {
                총점 = 점수계산기.getInstance()
                        .계산추가(Integer.parseInt(s[2]), 중간비율)
                        .계산추가(Integer.parseInt(s[3]), 기말비율)
                        .계산추가(Integer.parseInt(s[4]), 출석비율)
                        .계산추가(Integer.parseInt(s[5]), 과제비율)
                        .계산값받기();
            }catch (NumberFormatException e){
                총점 = 0;
                System.err.println("점수칸 채워주세요");
            }

            s[6] =Integer.toString(총점);
            if (총점 >= 학점점수[0])       s[7] = "A+";
            else if (총점 >= 학점점수[1])  s[7] = "A";
            else if (총점 >= 학점점수[2])  s[7] = "A-";
            else if (총점 >= 학점점수[3])  s[7] = "B+";
            else if (총점 >= 학점점수[4])  s[7] = "B";
            else if (총점 >= 학점점수[5])  s[7] = "B-";
            else if (총점 >= 학점점수[6])  s[7] = "C+";
            else if (총점 >= 학점점수[7])  s[7] = "C";
            else if (총점 >= 학점점수[8])  s[7] = "C-";
            else if (총점 >= 학점점수[9])  s[7] = "D+";
            else if (총점 >= 학점점수[10])  s[7] = "D";
            else if (총점 >= 학점점수[11])  s[7] = "D-";
            else s[7] = "F";
        }
    }

    public ArrayList 정보주기(){
        return 정보들;
    }

    public void 점수반영비율(int 중간비율, int 기말비율, int 출석비율, int 과제비율){
        this.중간비율 = 중간비율;
        this.기말비율 = 기말비율;
        this.기말비율 = 기말비율;
        this.과제비율 = 과제비율;
    }
    public void 학점점수설정(int[] 학점점수){
        this.학점점수 = 학점점수;
    }

    public int 중간비율얻기(){
        return 중간비율;
    }
    public int 기말비율얻기(){
        return 기말비율;
    }
    public int 출석비율얻기(){
        return 출석비율;
    }
    public int 과제비율얻기(){
        return 과제비율;
    }
    public int[] 학점점수얻기(){
        return 학점점수;
    }
}