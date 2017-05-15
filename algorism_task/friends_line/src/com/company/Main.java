package com.company;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        m.mainProgram();
    }

    public void mainProgram(){
        FriendsLine FL = FriendsLine.getInstance();

        Searcher searcher = new Searcher(FL);
        //searcher.startBFS(0);

        searcher.startDFS(0);
    }
}