package com.company.data_structure;

import com.company.Person;

/**
 * Created by Osy on 2017-05-14.
 */
public class Stack extends DataStructure{

    public Person pop(){
        int last = arrayList.size()-1;

        Person h = arrayList.get(last);
        arrayList.remove(last);
        return h;
    }
}
