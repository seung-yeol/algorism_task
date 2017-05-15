package com.company.data_structure;

import com.company.friendsliner.Person;

import java.util.ArrayList;

/**
 * Created by Osy on 2017-05-15.
 */
public abstract class DataStructure {
    protected ArrayList<Person> arrayList;      //Person객체 관하여 자료구조 수행하기위해

    public DataStructure(){
        arrayList = new ArrayList();
    }

    public abstract Person pop();       //pop의경우 자료구조에따라 다르므로

    public void push(Person h){
        arrayList.add(h);
    }   //push는 같기때문에
}
