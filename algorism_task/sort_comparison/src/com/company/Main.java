package com.company;

import com.company.sort.ArraySort;
import com.company.sort.sorts.HeapSort;
import com.company.sort.sorts.InsertionSort;
import com.company.sort.sorts.MergeSort;
import com.company.sort.sorts.QuickSort;

public class Main {
    static int i = 10;
    public static void main(String[] args) {
        Main m = new Main();
        m.zz();
    }
    public void sort(ArraySort arraySort, int[] array){
        arraySort.setArray(array);
        arraySort.sortStart();
        printArray(arraySort.getArray());
        int count = arraySort.getCount();
        System.out.println(count);
    }
    public void zz(){
        RandomArray randomArray;
        randomArray = new RandomArray(100);
        int[] array = randomArray.getArray();

        sort(new InsertionSort(),array);
        sort(new MergeSort(),array);
        sort(new QuickSort(),array);
    }
    void printArray(int[] array){
        for (int i = 0 ; i < array.length ; i++){
            System.out.print(array[i]+"\t");
        }
        System.out.println();
    }
}
