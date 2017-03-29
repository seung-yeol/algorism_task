package com.company.sort.sorts;

import com.company.sort.ArraySort;

/**
 * Created by Osy on 2017-03-28.
 */
public class MergeSort extends ArraySort {
    @Override
    public void sortStart(int[] array) {
        mergeSort(0, array.length, array);
    }
    public void mergeSort(int i , int arrayLength , int[] array){
        if (arrayLength - i != 1){
            int center = ( i + arrayLength-1 )/2;
            mergeSort(i, center , array);
            mergeSort(center+1 , array.length, array);
            merge(i, center, arrayLength, array);
        }
    }
    public void merge(int i, int center, int arrayLength, int[] array){
        int[] sortArray = array;
        int arrayLast = arrayLength-1;
        int j = i;
        while (i < center && center <= arrayLast) {
            if (array[i] <= array[center]){
                sortArray[j] = array[i];
                i++;
            }
            else{
                sortArray[j] = array[center];
                center++;
            }
            j++;
        }
        if (i == center){
            while (center <= arrayLast){
                sortArray[j] = array[center];
                center++;
                j++;
            }
        }
        else {
            while (i < center){
                sortArray[j] = array[i];
                i++;
                j++;
            }
        }
    }
}
