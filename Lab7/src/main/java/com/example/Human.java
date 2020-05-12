package com.example;

public abstract class Human implements GoingToWork {
    private String name; public String getName(){return name;}
    private String occupation; public String getOccupation(){return occupation;}
    public Human(String name, String occupation){
        this.name = name;
        this.occupation = occupation;
    }
}
