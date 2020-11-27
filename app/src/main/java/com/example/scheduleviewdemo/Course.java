package com.example.scheduleviewdemo;

public class Course {
    private int week;
    private int weekType;
    private int timeX;
    private int timeY;
    private int type;

    public Course() {
    }

    public Course(int week, int weekType, int timeX, int timeY,int type) {
        this.week = week;
        this.weekType = weekType;
        this.timeX = timeX;
        this.timeY = timeY;
        this.type = type;
    }

    public void setTimeX(int timeX) {
        this.timeX = timeX;
    }

    public void setTimeY(int timeY) {
        this.timeY = timeY;
    }

    public int getWeek() {
        return week;
    }

    public int getTimeX() {
        return timeX;
    }

    public int getTimeY() {
        return timeY;
    }

    public int getType() {
        return type;
    }
}

