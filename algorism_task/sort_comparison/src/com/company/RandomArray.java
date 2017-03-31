package com.company;
/**
 * Created by Osy on 2017-03-28.
 */
class RandomArray {
    private int[] ranArray;
    public RandomArray(int arrayLength){
        setArray(arrayLength);
    }
    private void setArray(int arrayLength) {
        ranArray = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            ranArray[i] = (int) (Math.random() * (arrayLength*2)); //길이의 두배만큼의 값이 나

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
