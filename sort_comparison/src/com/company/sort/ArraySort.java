package com.company.sort;

/**
 * Created by Osy on 2017-03-28.
 */
public abstract class ArraySort {
    protected int count = 0;
    protected int needSort;
    protected int target = 0;
    public void sortedArray(int[] array ,int arraySize){
        for (int i = 0; i < arraySize  ; i++){
            System.out.print(array[i] + "\t");
            if (i % 20 == 19) System.out.println();
        }
    }
    public int getCount(){
        return this.count;
    }
    public abstract void sortStart(int[] array);
}
