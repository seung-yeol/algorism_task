package com.company.data_structure;

import com.company.friendsliner.Person;

/**
 * Created by Osy on 2017-05-14.
 */
public class Stack extends DataStructure{   //이번 과제서 사용하지 않음

    public Person pop(){
        int last = arrayList.size()-1;

        Person h = arrayList.get(last); //stack은 최근에 들어온게 가장빨리나가므로
        arrayList.remove(last);         //리스트에서 삭제.
        return h;
    }
}
