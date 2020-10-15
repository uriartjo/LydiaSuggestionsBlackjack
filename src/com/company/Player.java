package com.company;

public class Player {
    private String name;
    private int points;
    private int numberOfWins;
    private int playStatus; // 0 = not playing, 1 = playing, 2 = hold, 3 = bust

    public Player(String theirName) {
        name = theirName;
        points = 0;
        numberOfWins = 0;
        playStatus = 0;
    }

    public void clearPoints() {
    }

    public int getPoints() {
    }

    public void addPoints(int pointsToAdd) {
    }

    public String getName() {
    }

    public void setPlayStatus(int status) {
    }

    public int getPlayStatus() {
    }

    public int getNumberOfWins() {
    }

}
