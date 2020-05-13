package com.example;

public class Student implements IGoingToWork {
    private final String messagePrefix = "Student";
    @Override
    public void wakeUp() {
        System.out.println(messagePrefix+" woke up at 7:00 AM");
    }

    @Override
    public void eat() {
        System.out.println(messagePrefix+" ate at 7:20 AM");
    }

    @Override
    public void goToWork() {
        System.out.println(messagePrefix+" is going to university at 7:25 AM");
    }
}
