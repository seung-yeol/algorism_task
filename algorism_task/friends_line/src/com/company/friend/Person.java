package com.company.friend;

import java.util.ArrayList;

/**
 * Created by Osy on 2017-05-09.
 */
public class Person {
    private String name;
    private int position;
    private boolean pass;

    ArrayList<Person> friends = new ArrayList();
    ArrayList<Integer> closeness = new ArrayList();

    public Person(String name){
        this.name = name;
        pass = false;
    }

    public String getName() {
        return name;
    }

    public void friendSet(Person p, int i){
        friends.add(p);
        closeness.add(i);
    }

    public ArrayList getFriends(){
        return friends;
    }

    public void passTrue(){
        pass = true;
    }

    public void passFalse(){
        pass = false;
    }

    public boolean getPass(){
        return pass;
    }
}