package com.example.martoraneca.challengegenerator.data;

public class ListItem {

    private String challenges;
    private String times;
    private int drawables;

    ListItem(String challenges, String times, int drawables) {
        this.challenges = challenges;
        this.times = times;
        this.drawables = drawables;
    }

    public String getChallenges() {
        return challenges;
    }

    public String getTimes() {
        return times;
    }

    public int getDrawables() {
        return drawables;
    }
}
