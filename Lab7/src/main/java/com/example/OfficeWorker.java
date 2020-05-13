package com.example;

public class OfficeWorker implements IGoingToWork {
    private final String messagePrefix = "Office Worker";
    @Override
    public void wakeUp() {
        System.out.println(messagePrefix+" woke up at 5:30 AM");
    }

    @Override
    public void eat() {
        System.out.println(messagePrefix+" ate up at 5:45 AM");
    }

    @Override
    public void goToWork() {
        System.out.println(messagePrefix+" is going to work at 5:50 AM");
    }
}
