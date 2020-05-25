package com.company;

import java.util.Set;
import java.lang.Math;

public class Board {

    private int dimension;
    private int size;
    private int[][] rows;
    private boolean[][] indicators; //this will represent which values are permanent

    Board(int dimension){
        this.dimension = dimension;
        size = dimension * dimension;
        //For example, dimension of 3 gives 9 x 9 board

        //Initialise board
        rows = new int[size][];
        for (int i=0; i < size; i++){
            rows[i] = new int[size];
        }
    }

    Board(int[][] board){
        rows = board;
        size = rows.length;
        dimension = (int) Math.sqrt(size);

        indicators = new boolean[size][size];
        for(int i=0; i < size; i++){
            for (int j=0; j<size; j++){
                indicators[i][j] = (rows[i][j] != 0);
            }
        }
    }

    Pair check(){
        return null;
    }
}
