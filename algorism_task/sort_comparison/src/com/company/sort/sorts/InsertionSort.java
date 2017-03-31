package com.company.sort.sorts;

import com.company.sort.ArraySort;

/**
 * Created by Osy on 2017-03-28.
 */
public class InsertionSort extends ArraySort {
    @Override
    public void sortStart() {
        int tmp = 0;
        for(int loc = 1; loc < array.length; loc++){
            tmp = array[loc];
            for(target = loc-1; target >= 0; target--){
                if (tmp < array[target]){
                    array[target+1] = array[target];
                    count++;

                }
                else {
                    count++;
                    break;
                }
            }
            array[target+1] = tmp;
            count++;
        }

    }
}
