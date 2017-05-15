package com.company.data_structure;

import com.company.friendsliner.Person;

/**
 * Created by Osy on 2017-05-14.
 */
public class Queue extends DataStructure{

    @Override
    public Person pop(){        //Queue는 처음 들어온게 먼저 pop되므로
        Person h = arrayList.get(0);
        arrayList.remove(0);
        return h;
    }
}
