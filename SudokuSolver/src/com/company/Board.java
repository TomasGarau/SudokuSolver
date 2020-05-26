package com.company;

import java.util.Set;
import java.lang.Math;

public class Board {

    private int dimension; //size of each sub-grid
    private int size; //size of the whole grid
    private int[][] grid;
    private boolean[][] indicators; //this will represent which values are permanent

    Board(int dimension){
        this.dimension = dimension;
        size = dimension * dimension;
        //For example, dimension of 3 gives 9 x 9 board

        //Initialise board
        grid = new int[size][size];
    }

    Board(int[][] board){
        grid = board;
        size = board.length;
        dimension = (int) Math.sqrt(size);

        indicators = new boolean[size][size];
        for(int i=0; i < size; i++){
            for (int j=0; j < size; j++){
                indicators[i][j] = (grid[i][j] != 0);
            }
        }
    }

    int[] check(){
        //Could be more efficient but cba
        for (int i=0; i < size; i++){
            for (int j=0; j < size; j++){
                if (!isValueValid(i,j)){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    boolean isValueValid(int row, int col){
        int value = grid[row][col];
        int i, j;

        //Check horizontal
        for (j=0; j<size; j++){
            if (grid[row][j] == value && j != col){
                return false;
            }
        }
        //Check vertical
        for (i=0; i<size; i++){
            if (grid[i][col] == value && i != row){
                return false;
            }
        }
        //Check box
        /* Find co-ordinates of box by seeing how many times the co-ordinates of the value divides  fully
           by the size of the box then times the result by the size of the box */
        int box_x = (row/dimension) * dimension;
        int box_y = (col/dimension) * dimension;
        for (i=box_x; i<box_x + dimension; i++){
            for (j=box_y; j<box_y + dimension; j++){
                if (grid[i][j] == value && i != row && j != col){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isMutable(int row, int col){
        return indicators[row][col];
    }

    protected void setValue(int row, int col, int val) throws IllegalArgumentException {
        if (indicators[row][col]){
            throw new IllegalArgumentException("Sudoku value is immutable. Row: " + row + ", Col: " + col);
        } else {
            grid[row][col] = val;
        }
    }

    public int getSize(){
        return size;
    }
}
