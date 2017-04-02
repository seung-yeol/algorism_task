package com.company.sort.sorts;

import com.company.sort.ArraySort;

public class MergeSort extends ArraySort {
    int[] sortArray;
    @Override
    public void sortStart() {
        sortArray = new int[array.length];
        mergeSort(0, array.length-1);
        this.array = sortArray;
    }
    private void mergeSort( int left, int right) {
        int mid;
        count++;
        if(left < right){
            mid = ( left + right)/2;
            mergeSort( left, mid);
            mergeSort(mid+1, right);
            merge( left, mid, right);
        }
    }
    private void merge(int left, int mid, int right){
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
                count++;
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
            count++;
        }
        for(int i = left; i < right+1 ; i++){
            array[i] = sortArray[i];
            count++;
        }
    }
}