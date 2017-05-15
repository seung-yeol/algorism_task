package com.company.friendsliner;

import java.util.ArrayList;

/**
 * Created by Osy on 2017-05-09.
 */
public class Person {
    private String name;        //  사람이름
    private boolean pass;       //  정점 경유시 true

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
        friends.add(p);         //친구추가
        closeness.add(i);       //친밀도추가
    }

    public ArrayList getFriends(){
        return friends;
    }

    public void passTrue(){
        pass = true;
    }       //경유시 true

    public void passFalse(){
        pass = false;
    }     //리셋

    public boolean getPass(){
        return pass;
    }     //경유확인
}