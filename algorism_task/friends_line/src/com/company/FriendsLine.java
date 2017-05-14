package com.company;

import com.company.friend.Person;

/**
 * Created by Osy on 2017-05-15.
 */
public class FriendsLine {
    private final Person[] people;
    private static final FriendsLine INSTANCE = new FriendsLine() ;

    private FriendsLine(){
        people = new Person[15];

        people[0] = new Person("김시작");
        people[1] = new Person("가우리");
        people[2] = new Person("나나바");
        people[3] = new Person("다람쥐");
        people[4] = new Person("라디오");
        people[5] = new Person("마오리");
        people[6] = new Person("바나나");
        people[7] = new Person("사나이");
        people[8] = new Person("아이유");
        people[9] = new Person("자엽초");
        people[10] = new Person("차떼기");
        people[11] = new Person("카르마");
        people[12] = new Person("타우린");
        people[13] = new Person("파스칼");
        people[14] = new Person("하이디");

        setFriendsLine();
    }

    private void setFriendsLine(){
        setFriend(people[0], people[4],7);
        setFriend(people[0], people[5],3);
        setFriend(people[0], people[7],5);
        setFriend(people[1], people[2],2);
        setFriend(people[1], people[6],4);
        setFriend(people[1], people[7],9);
        setFriend(people[2], people[7],1);
        setFriend(people[2], people[11],4);
        setFriend(people[3], people[5],6);
        setFriend(people[3], people[10],8);
        setFriend(people[4], people[5],3);
        setFriend(people[4], people[8],4);
        setFriend(people[4], people[9],5);
        setFriend(people[5], people[14],8);
        setFriend(people[6], people[9],7);
        setFriend(people[6], people[10],3);
        setFriend(people[7], people[8],4);
        setFriend(people[8], people[12],3);
        setFriend(people[9], people[10],2);
        setFriend(people[9], people[13],9);
        setFriend(people[10], people[12],1);
        setFriend(people[11], people[13],4);
        setFriend(people[11], people[14],8);
        setFriend(people[12], people[13],2);
        setFriend(people[13], people[14],6);
    }

    private void setFriend(Person p1, Person p2, int closeness){
        p1.friendSet(p2,closeness);
        p2.friendSet(p1,closeness);
    }

    public Person[] getPeople(){
        return people;
    }

    public static FriendsLine getInstance(){
        return INSTANCE;
    }
}
