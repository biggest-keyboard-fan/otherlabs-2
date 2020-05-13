package com.example;

public class RegularWorker implements IGoingToWork {
    private final String messagePrefix = "Regular worker";
    @Override
    public void wakeUp() {
        System.out.println(messagePrefix+" woke up at 6:00 AM");
    }

    @Override
    public void eat() {
        System.out.println(messagePrefix+" ate at 6:30 AM");
    }

    @Override
    public void goToWork() {
        System.out.println(messagePrefix+" is going to work at 6:50 AM");
    }
}
