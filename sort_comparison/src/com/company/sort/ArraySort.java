package com.company.sort;

/**
 * Created by Osy on 2017-03-28.
 */
public abstract class ArraySort {
    protected int count = 0;
    protected int needSort;
    protected int target = 0;
    protected int[] array;
    public void getSortedArray(){
        try {
            for (int i = 0; i < array.length  ; i++){
                System.out.print(array[i] + "\t");
                if (i % 20 == 19) System.out.println();
            }
        }catch (NullPointerException e){
            System.out.println("sortStart메소드로 정렬된 배열을 만들어주세요");
            e.printStackTrace();
        }
    }
    public int getCount(){
        return this.count;
    }
    public abstract void sortStart(int[] array);
}
