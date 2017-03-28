package com.company;

/**
 * Created by Osy on 2017-03-28.
 */
public class RandomArray {
    int[] ranArray;
    public RandomArray(){
        setArray();
    }
    public void setArray() {
        for (int i = 0; i < ranArray.length; i++) {
            ranArray[i] = (int) (Math.random() * 200);  //최대 199뜸

            for (int j = 0; j < i; j++) {               //이전에 나왓을경우 더돌림
                if (ranArray[i] == ranArray[j]) {
                    i--;
                    break;
                }
            }
        }
    }
    public int[] getArray(){
        return this.ranArray;
    }
}
