package com.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Arrays.stream(new Human[]{new Human("Paul", new OfficeWorker()), new Human("Greg", new RegularWorker()), new Human("Bob", new Student())}).forEach((human -> {
            human.getWork().wakeUp();
            human.getWork().eat();
            human.getWork().goToWork();
        }));
    }
}
