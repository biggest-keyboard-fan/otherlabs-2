package com.example;

public class Human {
    private String name; public String getName(){return name;}
    private IGoingToWork work; public IGoingToWork getWork(){return work;}
    public Human(String name, IGoingToWork work){
        this.name = name;
        this.work = work;
    }
}
