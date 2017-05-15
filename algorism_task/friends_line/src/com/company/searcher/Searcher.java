package com.company.searcher;

import com.company.friendsliner.FriendsLiner;
import com.company.friendsliner.Person;

import java.util.ArrayList;

/**
 * Created by Osy on 2017-05-14.
 */
public abstract class Searcher {
    Person[] people;                // FriendsLiner로부터 값을 받기위한
    ArrayList<Person> arr;          // 친구 리스트를 담기위한 리스트


    public Searcher(FriendsLiner friendsLiner){
        people = friendsLiner.getPeople();      //Friendsline 정보 받아옴
    }

    public abstract void startSearch(int startNum);   //검색 시작
}