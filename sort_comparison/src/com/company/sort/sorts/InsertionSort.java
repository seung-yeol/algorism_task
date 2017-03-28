package com.company.sort.sorts;

import com.company.sort.ArraySort;

/**
 * Created by Osy on 2017-03-28.
 */
public class InsertionSort extends ArraySort {
    @Override
    public void sortStart(int[] array) {
        for (int loc = 1; loc < 100; loc++){
            if (array[loc-1] > array[loc]){
                needSort = array[loc];
                if (loc != 1){
                    for (int i = loc-2; i >= 0; i--){
                        if(array[i] < needSort){
                            target = i + 1;
                            count++;
                            break;
                        }
                    }
                }
                for (int k = loc - 1; k >= target; k--){
                    array[k+1] = array[k];
                    count++;
                }
                array[target] = needSort;
                count++;
            }
        }
    }
}
