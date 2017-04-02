package com.company.sort;

/**
 * Created by Osy on 2017-03-28.
 */
public abstract class ArraySort {
    protected int count = 0;
    protected int[] array;
    public abstract void sortStart();
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
    protected void swap(int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
        count++;
    }
}
