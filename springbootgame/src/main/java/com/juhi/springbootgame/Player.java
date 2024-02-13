package com.juhi.springbootgame;

public class Player {
    private String name;
    private int nmbr;
    private int points;

    public Player(String name, int nmbr) {
        this.name = name;
        this.nmbr = nmbr;
        this.points = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setNmbr(int nmbr) {
        this.nmbr = nmbr;
    }

    public int getNmbr() {
        return this.nmbr;
    }

    public void addPoints(int toAdd) {
        this.points += toAdd;
    }

    public void resetPoints() {
        this.points = 0;
    }

    public int getPoints() {
        return this.points;
    }
}
