package com.company.sort;

/**
 * Created by Osy on 2017-03-28.
 */
public abstract class ArraySort {
    protected int count = 0;
    protected int target = 0;
    protected int[] array;
    public int[] getArray(){
        if (array == null){
            throw new NullPointerException();
        }
        return array;
    }
    public int getCount(){
        return this.count;
    }
    public void setArray(int[] array){
        this.array = new int[array.length];
        System.arraycopy(array, 0, this.array,0, array.length);
    }
    public abstract void sortStart();
}
