package com.company.data_structure;

import com.company.Person;

import java.util.ArrayList;

/**
 * Created by Osy on 2017-05-15.
 */
public abstract class DataStructure {
    protected ArrayList<Person> arrayList;

    public DataStructure(){
        arrayList = new ArrayList();
    }

    public abstract Person pop();

    public void push(Person h){
        arrayList.add(h);
    }
}
