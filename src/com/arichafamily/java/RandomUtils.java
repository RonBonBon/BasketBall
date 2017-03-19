package com.arichafamily.java;

import java.util.Random;

public class RandomUtils {
    //Private fields:
    private static Random randGen = new Random();

    //No instances allowed
    private RandomUtils() {
    }

    public static int getInt() {
        return randGen.nextInt();
    }

    public static int getInt(int from, int to){
       int range = to - from;
       return from + randGen.nextInt(range + 1);
    }
}
