package com.company;

import com.company.friend.Person;
import com.company.data_structure.Queue;
import com.company.data_structure.Stack;

import java.util.ArrayList;

/**
 * Created by Osy on 2017-05-14.
 */
public class Searcher {
    ArrayList<Person> arr;
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
        stack.push(people[startNum]);
        DFS(people[startNum]);

    }

    public void BFS(Person person){
        arr = person.getFriends();

        for (Person p : arr){
            if (p.getPass() == false){
                System.out.print(" - " + p.getName());
                p.passTrue();
                queue.push(p);
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
        arr = person.getFriends();

        for (Person p : arr) {
            if (p.getPass() == false) {
                System.out.print(" - " + p.getName());
                p.passTrue();
                DFS(p);
            } else {

            }
        }
    }
}