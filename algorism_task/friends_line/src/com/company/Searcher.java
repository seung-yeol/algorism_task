package com.company;

import com.company.friend.Person;
import com.company.data_structure.Queue;
import com.company.data_structure.Stack;

import java.util.ArrayList;

/**
 * Created by Osy on 2017-05-14.
 */
public class Searcher {
    Person[] people;
    Queue queue;
    Stack stack;

    public Searcher(FriendsLine friendsLine){
        people = friendsLine.getPeople();
    }

    public void startBFS(int startNum){
        queue = new Queue();

        System.out.println("BFS로 친구 탐색");
        System.out.print(people[startNum].getName());

        people[startNum].passTrue();
        BFS(people[startNum]);
    }

    public void startDFS(int startNum){
        stack = new Stack();

        System.out.println("BFS로 친구 탐색");
        System.out.print(people[startNum].getName());

        people[startNum].passTrue();
        DFS(people[startNum]);

    }

    public void BFS(Person person){
        ArrayList<Person> arr = person.getFriends();

        for (Person h : arr){
            if (h.getPass() == false){
                System.out.print(" - " + h.getName());
                h.passTrue();
                queue.push(h);
            }
        }

        try {
            BFS(queue.pop());
        }
        catch (IndexOutOfBoundsException e){
            return;
        }
    }
    public void DFS(Person person){
        ArrayList<Person> arr = person.getFriends();


        try {
            DFS(queue.pop());
        }
        catch (IndexOutOfBoundsException e){
            return;
        }
    }


}
