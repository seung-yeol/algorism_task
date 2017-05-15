package com.company;

import com.company.friendsliner.FriendsLiner;
import com.company.searcher.BFS;
import com.company.searcher.DFS;
import com.company.searcher.Searcher;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        m.mainProgram();
    }

    public void mainProgram(){
        FriendsLiner FL = FriendsLiner.getInstance();   //프렌즈라인 객체생성

        BFS bfs = new BFS(FL);      //BFS 객체 생성 및 프렌즈라인정보 전달
        searchStart(bfs,0);    //BFS 방법으로 0번 정점부터 탐색

        FL.setFalse();              //탐색을 한번 더 하기위해 경유체크 리셋

        System.out.println();
        DFS dfs = new DFS(FL);      //DFS 객체 생성 및 프렌즈라인정보 전달
        searchStart(dfs,0);    //DFS 방법으로 0번 정점부터 탐색
    }

    public void searchStart(Searcher searcher, int num){
        searcher.startSearch(num);
    }
}