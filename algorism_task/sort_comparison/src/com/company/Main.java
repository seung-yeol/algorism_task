package com.company;

import com.company.sort.ArraySort;
import com.company.sort.sorts.HeapSort;
import com.company.sort.sorts.InsertionSort;
import com.company.sort.sorts.MergeSort;

public class Main {
    static int i = 10;
    public static void main(String[] args) {
        int[] array;
        RandomArray randomArray;
        Main m = new Main();

        randomArray = new RandomArray(100);
        array = randomArray.getArray();
        m.zz(new MergeSort(),array);

    }
    public void zz(ArraySort arraySort, int[] array){
        arraySort.sortStart(array);
        arraySort.getSortedArray();
        int count = arraySort.getCount();
        System.out.println(count);
    }
}
