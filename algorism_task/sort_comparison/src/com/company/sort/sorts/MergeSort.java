package com.company.sort.sorts;

import com.company.sort.ArraySort;

public class MergeSort extends ArraySort {
    int[] sortArray;
    @Override
    public void sortStart(int[] array) {
        sortArray = new int[array.length];
        mergeSort(array, 0, array.length-1);
        this.array = sortArray;
    }
    private void mergeSort(int[] array, int left, int right) {
        int mid;
        this.count++;
        if(left < right){
            mid = (left + right)/2;
            mergeSort(array, left, mid);
            mergeSort(array, mid+1, right);
            merge(array, left, mid, right);
        }
    }
    private void merge(int[] array, int left, int mid, int right){
        int sLeft = left;
        int sMid = mid + 1;
        int target = left;

        while( sLeft <= mid || sMid <= right){
            if( sLeft <= mid && sMid <= right){
                if(array[sLeft] <= array[sMid]){
                    sortArray[target] = array[sLeft];
                    sLeft++;
                }
                else{
                    sortArray[target] = array[sMid];
                    sMid++;
                }
            }
            else if( sLeft <= mid && sMid > right){ //왼쪽거 남음
                sortArray[target] = array[sLeft];
                sLeft++;
            }
            else{                                   //오른쪽거 남음
                sortArray[target] = array[sMid];
                sMid++;
            }
            target++;
            this.count++;
        }
        for(int i = left; i < right+1 ; i++){
            array[i] = sortArray[i];
            this.count++;
        }
    }
}
