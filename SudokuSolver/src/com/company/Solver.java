package com.company;

public final class Solver {

    static Board solve(Board board){
        return solve(board, 0, 0);
    }

    static Board solve(Board board, int start_x, int start_y){
        final int SIZE = board.getSize();

        for (int row = start_x; row < SIZE; row++){

            for (int col = start_y; col < SIZE; col++){

                if (board.isMutable(row,col)) {
                    for (int value = 1; value <= SIZE; value++){

                        board.setValue(row, col, value);
                        if (board.isValueValid(row, col)){
                            break;
                        }
                        if (value == SIZE){
                            return backtrack(board, row, col);
                        }
                    }
                }
            }
        }
        return board;
    }

    static Board backtrack(Board board, int x, int y){
        //solve(board, new_x, new_y)
        return board;
    }
}
