package com.company.sort.sorts;

import com.company.sort.ArraySort;
/**
 * Created by Osy on 2017-03-28.
 */
public class QuickSort extends ArraySort {
    @Override
    public void sortStart() {
        divArray(0,array.length-1);
    }
    public void divArray( int p, int r){
        if (p < r){
            int lCnt = partition( p, r);
            divArray( p, lCnt-1);
            divArray(lCnt+1, r);
            count++;
        }
    }
    public int partition( int j, int r){
        int bibi = array[r];
        int lCnt = j;
        int tmp;

        while (j < r){
            if(array[j] <= bibi){
                tmp = array[lCnt];
                array[lCnt] = array[j];
                array[j] = tmp;
                lCnt++;
                count++;
            }
            j++;
            count++;
        }
        tmp = array[lCnt];
        array[lCnt] = bibi;
        array[r] = tmp;
        count++;
        return lCnt;
    }
}