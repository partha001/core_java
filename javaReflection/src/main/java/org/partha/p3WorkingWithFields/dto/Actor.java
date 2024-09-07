package org.partha.p3WorkingWithFields.dto;

public class Actor {

    private final String name;
    private final String[] knownFormMovies;

    public Actor(String name,String[] knownFormMovies){
        this.name = name;
        this.knownFormMovies = knownFormMovies;
    }
}
