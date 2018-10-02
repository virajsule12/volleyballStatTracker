package com.example.rc211.volleyballstattracker;

public class Player {

    private String name;
    private int playerType;
    /*numbers corresponding to position
    1 = right-back
    2 = right-side
    3 = middle
    4 = outside
    5 = left-back
    6 = libero/middle back
     */

    //front-row stats
    private int hits;
    private int blocks;
    private int kills;
    private int bounce;

    //back-row stats
    private int dig;
    private int passes;
    private int sets;

    //all-positions stats
    private int ace;
    private int serves;
    private int assist;
    private int points;

    //error stats
    private int serviceErrors;
    private int miscommunication;
    private int missedPasses;

    public Player(String name, int position){

        this.name = name;

        playerType = position;

        hits = 0;
        blocks = 0;
        kills = 0;
        bounce = 0;

        dig = 0;
        passes = 0;
        sets = 0;

        ace = 0;
        serves = 0;
        assist = 0;
        points = 0;

        serviceErrors = 0;
        miscommunication = 0;
        missedPasses = 0;
    }

}
