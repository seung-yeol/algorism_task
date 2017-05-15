package com.company.searcher;

import com.company.friendsliner.FriendsLiner;
import com.company.friendsliner.Person;

/**
 * Created by Osy on 2017-05-15.
 */
public class DFS extends Searcher {
    private int count;      //들른 정점 수 카운트
    public DFS(FriendsLiner friendsLiner) {
        super(friendsLiner);
        count = 0;
    }

    @Override
    public void startSearch(int startNum){
        System.out.println("DFS로 친구 탐색");
        System.out.print(people[startNum].getName());

        people[startNum].passTrue();
        DFS(people[startNum]);
    }

    public void DFS(Person person){
        arr = person.getFriends();

        for (Person p : arr) {
            if (p.getPass() == false) {
                System.out.print(" - " + p.getName());
                p.passTrue();
                count++;
                DFS(p);
            }
            if (count == 14) return;    //모든 경유지 경유한 경우 메소드 종료
        }
    }
}
