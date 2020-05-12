package com.example;

public class Singleton {
    private static Singleton instance;

    public final String FILE_PATH_FIRST="first.txt", FILE_PATH_SECOND="second.txt", FILE_PATH_THIRD="third.txt";

    private Singleton(){}
    public static Singleton getInstance() {
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
