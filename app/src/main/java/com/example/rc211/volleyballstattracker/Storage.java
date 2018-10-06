package com.example.rc211.volleyballstattracker;

import android.webkit.WebHistoryItem;

import java.util.ArrayList;
import java.util.List;

public class Storage {

    private List<String> stats = new ArrayList<>();

    /*order of stats in stats array list:
    hits
    blocks
    kills
    tips
    digs
    passes
    sets
    aces
    serves
    assists
    points
    serviceErrors
    */

    public Storage(){

    }

    public void addStats(String statistics){//method that adds a string in stats array list
        stats.add(statistics);
    }

    public String getStats(int i){//method that returns one type of statistic for every game recorded
        return stats.get(i);
    }

    public void addNewStats(String newStats){//method which separates strings by commas and adds the string in between commas to stats array list

        for (int i = 0;i < 12;i++){
            String current = stats.get(i) + newStats.substring(0, newStats.indexOf(",")) + ",";
            stats.set(i, current);
            if (i != 11){
                newStats = newStats.substring(newStats.indexOf(",")+1, newStats.length());
            }
        }

    }
}
