package com.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Arrays.stream(new Human[]{new OfficeWorker("Paul"), new RegularWorker("Greg"), new Student("Bob")}).forEach((human -> {
            human.wakeUp();
            human.eat();
            human.goToWork();
        }));
    }
}
