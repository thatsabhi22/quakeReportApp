package com.example.android.quakereport;

public class Earthquake {

    double magnitude;
    String location;
    String date;

    public Earthquake(double magnitude, String location, String date) {
        this.magnitude = magnitude;
        this.location = location;
        this.date = date;
    }
}
