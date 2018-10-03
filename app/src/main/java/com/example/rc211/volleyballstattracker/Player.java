package com.example.rc211.volleyballstattracker;

public class Player {

    private String name;
    private int playerType;
    /*numbers corresponding to position
    0 = right-back
    1 = right-side
    2 = middle
    3 = outside
    4 = left-back
    5 = libero/middle back
     */

    //front-row stats
    private int hits;
    private int blocks;
    private int kills;
    private int tips;

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

    public Player(String name, int position){

        this.name = name;

        playerType = position;

        hits = 0;
        blocks = 0;
        kills = 0;
        tips = 0;

        dig = 0;
        passes = 0;
        sets = 0;

        ace = 0;
        serves = 0;
        assist = 0;
        points = 0;

        serviceErrors = 0;
    }

//    public void setHits(int numHits){
//        hits = numHits;
//    }

    public void increaseHit(){
        hits++;
    }

    public int getHits(){
        return hits;
    }

    public void increaseBlock(){
        blocks++;
    }

    public int getBlocks(){
        return blocks;
    }

    public void increaseKill(){
        kills++;
    }

    public int getKills(){
        return kills;
    }

    public void increaseTip(){
        tips++;
    }

    public int getTips(){
        return tips;
    }

    public void increaseDig(){
        dig++;
    }

    public void increasePass(){
        passes++;
    }

    public void increaseSets(){
        sets++;
    }

    public void increaseAce(){
        ace++;
    }

    public void increaseServe(){
        serves++;
    }

    public void increaseAssist(){
        assist++;
    }

    public void increasePoints(){
        points++;
    }

    public void increaseServiceErrors(){
        serviceErrors++;
    }

    public String getName() {
        return name;
    }

    public int getPasses() {
        return passes;
    }

    public int getPlayerType() {
        return playerType;
    }

    public int getDig() {
        return dig;
    }

    public int getSets() {
        return sets;
    }

    public int getAce() {
        return ace;
    }

    public int getServes() {
        return serves;
    }

    public int getAssist() {
        return assist;
    }

    public int getPoints() {
        return points;
    }

    public int getServiceErrors() {
        return serviceErrors;
    }

    public int getDigs(){
        return dig;
    }
}
