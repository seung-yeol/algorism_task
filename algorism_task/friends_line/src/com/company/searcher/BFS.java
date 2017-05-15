package com.company.searcher;

import com.company.friendsliner.FriendsLiner;
import com.company.friendsliner.Person;
import com.company.data_structure.Queue;

/**
 * Created by Osy on 2017-05-15.
 */
public class BFS extends Searcher {
    Queue queue;        //BFS는 큐가 필요하므로

    public BFS(FriendsLiner friendsLiner) {
        super(friendsLiner);
    }

    @Override
    public void startSearch(int startNum){
        queue = new Queue();

        System.out.println("BFS로 친구 탐색");
        System.out.print(people[startNum].getName());   //맨 처음 정점 이름 출력

        people[startNum].passTrue();
        BFS(people[startNum]);
    }

    public void BFS(Person person){
        arr = person.getFriends();  //정점의 친구리스트

        for (Person p : arr){
            if (p.getPass() == false){  //경유하지 않은 정점인경우 실행
                System.out.print(" - " + p.getName());
                p.passTrue();           //경유했다는 표시
                queue.push(p);          //큐에 넣음
            }
        }

        try {
            BFS(queue.pop());   //다음 너비탐색을 위해 큐에서 값 꺼내오고 BFS다시실행
        }
        catch (IndexOutOfBoundsException e){    //이 예외가 뜨는경우는 모든 정점 경유
            return;
        }
    }
}
