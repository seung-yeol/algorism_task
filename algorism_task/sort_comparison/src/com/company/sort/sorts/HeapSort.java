package com.company.sort.sorts;

import com.company.sort.ArraySort;

/**
 * Created by Osy on 2017-03-28.
 */
public class HeapSort extends ArraySort{
    @Override
    public void sortStart() {
        buildHeap(array.length);
        for (int i = array.length; i > 1; i-- ){
            swap(0, i-1);
            heapify(1, i-1);
        }
    }
    public void heapify(int i, int n) {
        int left = i * 2;
        int right = left + 1;
        int small;
        count++;

        if (right <= n ){
            if (array[left-1] <= array[right-1]) small = left;
            else small = right;
            count++;
        }
        else if (left <= n) small = left;
        else return;

        if ( array[small-1] < array[i-1]) {
            swap(i-1, small-1);
            heapify(small, n);
            count++;
        }
    }
    public void buildHeap(int n){
        for (int i = n/2 ; i > 0 ; i--){
            heapify(i, n);
            count++;
        }
    }
}
