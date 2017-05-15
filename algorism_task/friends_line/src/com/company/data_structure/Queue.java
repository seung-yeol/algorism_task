package com.company.data_structure;

import com.company.Person;

/**
 * Created by Osy on 2017-05-14.
 */
public class Queue extends DataStructure{

    @Override
    public Person pop(){
        Person h = arrayList.get(0);
        arrayList.remove(0);
        return h;
    }
}
