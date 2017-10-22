package com.mmg;

public class GameModel {

    public static final int BLACK = 0;
    public static final int WHITE = 1;
    public static final int POSSIBLE = 2;

    int[][] data = new int[8][8];

    public int[][] getBoardData(){
        // TODO: Add observer pattern
        // TODO: Work with threads to allow two players
        return data;
    }

}
