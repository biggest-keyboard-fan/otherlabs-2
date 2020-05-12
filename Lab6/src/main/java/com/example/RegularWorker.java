package com.example;

public class RegularWorker extends Human {
    public RegularWorker(String name) {
        super(name, "Regular Worker");
    }
    private final String messagePrefix = getOccupation() + " " + getName();
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
