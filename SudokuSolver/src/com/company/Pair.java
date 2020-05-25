package com.company;
import java.awt.Point;

//This class is specifically used to return two co-ordinates if
//a clash is found in 'check' method in Board.java
public class Pair {

    Point first;
    Point second;

    Pair(int first_x, int first_y, int second_x, int second_y){
        first = new Point(first_x, first_y);
        second = new Point(second_x, second_y);
    }

    public String toString(){
        return first.toString() + ", " + second.toString();
    }
}
