package com.company;

public class Main {

    public static void main(String[] args) {

        Board[] tests = new Board[3];
        tests[0] = new Board(b1);
        tests[1] = new Board(b2);
        tests[2] = new Board(b3);

        for (int i=0; i<tests.length; i++) {
            Board board = tests[i];
            Solver.solve(board);
            if (board.check() == null){
                System.out.println("Test " + i + " passed!");
            }
            else {
                int[] pair = board.check();
                System.out.println("Test " + i + " failed.");
                System.out.println("Clash at: " +  pair.toString());
            }
        }
    }

    static int[][] b1 = {
            {5,3,0,0,7,0,0,0,0},
            {6,0,0,1,9,5,0,0,0},
            {0,9,8,0,0,0,0,6,0},
            {8,0,0,0,6,0,0,0,3},
            {7,0,0,0,2,0,0,0,6},
            {0,6,0,0,0,0,2,8,0},
            {0,0,0,4,1,9,0,0,5},
            {0,0,0,0,8,0,0,7,9}
    };

    static int[][] b2 = {
            {0,4,0,2,0,1,0,6,0},
            {0,0,0,0,0,0,0,0,0},
            {9,0,5,0,0,0,3,0,7},
            {0,0,0,0,0,0,0,0,0},
            {5,0,7,0,8,0,1,0,4},
            {0,1,0,0,0,0,0,9,0},
            {0,0,1,0,0,0,6,0,0},
            {0,0,0,7,0,5,0,0,0},
            {6,0,8,9,0,4,5,0,3}
    };

    static int[][] b3 ={
            {0,0,0,0,5,0,0,0,0},
            {9,0,6,0,0,0,3,0,7},
            {0,1,0,0,0,0,0,5,0},
            {2,0,0,6,0,7,0,0,1},
            {0,4,0,0,0,0,0,9,0},
            {0,0,0,7,0,1,0,0,0},
            {7,0,9,0,0,0,2,0,6},
            {0,0,0,0,3,0,0,0,0}
    };
}
