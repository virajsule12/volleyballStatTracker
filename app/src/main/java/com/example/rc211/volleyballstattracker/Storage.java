package com.example.rc211.volleyballstattracker;

import java.util.ArrayList;
import java.util.List;

public class Storage {

    private List<String> stats = new ArrayList<>();

//    private String hits;
//    private String blocks;
//    private String kills;
//    private String tips;
//    private String digs;
//    private String passes;
//    private String sets;
//    private String aces;
//    private String serves;
//    private String assists;
//    private String points;
//    private String serviceErrors;

    public Storage(){

    }

    public void addStats(String statistics){
        stats.add(statistics);
    }

    public String getStats(int i){
        return stats.get(i);
    }
}
