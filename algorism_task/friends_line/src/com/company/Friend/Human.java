package com.company.Friend;

import java.util.ArrayList;

/**
 * Created by Osy on 2017-05-09.
 */
public class Human {
    private String name;
    ArrayList<Human> friend = new ArrayList();
    ArrayList<Integer> closeness = new ArrayList();

    public Human(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void friendSet(Human h,int i){
        friend.add(h);
        closeness.add(i);
    }
}