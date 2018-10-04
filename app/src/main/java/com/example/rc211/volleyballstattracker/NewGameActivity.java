package com.example.rc211.volleyballstattracker;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class NewGameActivity extends AppCompatActivity {

    //text files for saving stats
    public static final String FILE1 = "player1Stats.txt";
    public static final String FILE2 = "player2Stats.txt";
    public static final String FILE3 = "player3Stats.txt";
    public static final String FILE4 = "player4Stats.txt";
    public static final String FILE5 = "player5Stats.txt";
    public static final String FILE6 = "player6Stats.txt";

    private List<Player> players = new ArrayList<>();

    private int playerSelected;

    private CheckBox setter;
    private CheckBox rightside;
    private CheckBox middle;
    private CheckBox outside;
    private CheckBox leftback;
    private CheckBox libero;

    private TextView dispHitts;
    private TextView dispBlocks;
    private TextView dispKills;
    private TextView dispTips;
    private TextView dispDigs;
    private TextView dispPass;
    private TextView dispSets;
    private TextView dispAces;
    private TextView dispServes;
    private TextView dispAssists;
    private TextView dispPoints;
    private TextView dispServiceErrors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);

        //initialize players array
        players.add(new Player("", 1));
        players.add(new Player("", 2));
        players.add(new Player("", 3));
        players.add(new Player("", 4));
        players.add(new Player("", 5));
        players.add(new Player("", 6));

        setter = findViewById(R.id.setter);
        rightside = findViewById(R.id.rightside);
        middle = findViewById(R.id.middle);
        outside = findViewById(R.id.outside);
        leftback = findViewById(R.id.leftback);
        libero = findViewById(R.id.libero);

        dispHitts = findViewById(R.id.dispHit);
        dispBlocks = findViewById(R.id.dispBlock);
        dispKills = findViewById(R.id.dispKill);
        dispTips = findViewById(R.id.dispTips);
        dispDigs = findViewById(R.id.dispDigs);
        dispPass = findViewById(R.id.dispPasses);
        dispSets = findViewById(R.id.dispSets);
        dispAces = findViewById(R.id.dispAces);
        dispServes = findViewById(R.id.dispServes);
        dispAssists = findViewById(R.id.dispAssists);
        dispPoints = findViewById(R.id.dispPoints);
        dispServiceErrors = findViewById(R.id.dispServiceErrors);

        setter.setChecked(true);
        playerSelected = 0;
        selectPlayer();

        addHit();
        addBlock();
        addKills();
        addTips();
        addDig();
        addPasses();
        addSets();
        addAces();
        addServes();
        addAssist();
        addPoints();
        addServiceErrors();

        saveText();
        loadFile();

    }

    public void selectPlayer(){
        setter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setter.setChecked(true);
                rightside.setChecked(false);
                middle.setChecked(false);
                outside.setChecked(false);
                leftback.setChecked(false);
                libero.setChecked(false);

                playerSelected = 0;

                dispHitts.setText("Hits: " + players.get(playerSelected).getHits());
                dispBlocks.setText("Blocks: " + players.get(playerSelected).getBlocks());
                dispKills.setText("Kills: " + players.get(playerSelected).getKills());
                dispTips.setText("Tips: " + players.get(playerSelected).getTips());
                dispDigs.setText("Digs: " + players.get(playerSelected).getDigs());
                dispPass.setText("Passes: " + players.get(playerSelected).getPasses());
                dispSets.setText("Sets: " + players.get(playerSelected).getSets());
                dispAces.setText("Aces: " + players.get(playerSelected).getAces());
                dispServes.setText("Serves: " + players.get(playerSelected).getServes());
                dispAssists.setText("Assists: " + players.get(playerSelected).getAssists());
                dispPoints.setText("Points: " + players.get(playerSelected).getPoints());
                dispServiceErrors.setText("Service Errors: " + players.get(playerSelected).getServiceErrors());
            }
        });
        rightside.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setter.setChecked(false);
                rightside.setChecked(true);
                middle.setChecked(false);
                outside.setChecked(false);
                leftback.setChecked(false);
                libero.setChecked(false);

                playerSelected = 1;

                dispHitts.setText("Hits: " + players.get(playerSelected).getHits());
                dispBlocks.setText("Blocks: " + players.get(playerSelected).getBlocks());
                dispKills.setText("Kills: " + players.get(playerSelected).getKills());
                dispTips.setText("Tips: " + players.get(playerSelected).getTips());
                dispDigs.setText("Digs: " + players.get(playerSelected).getDigs());
                dispPass.setText("Passes: " + players.get(playerSelected).getPasses());
                dispSets.setText("Sets: " + players.get(playerSelected).getSets());
                dispAces.setText("Aces: " + players.get(playerSelected).getAces());
                dispServes.setText("Serves: " + players.get(playerSelected).getServes());
                dispAssists.setText("Assists: " + players.get(playerSelected).getAssists());
                dispPoints.setText("Points: " + players.get(playerSelected).getPoints());
                dispServiceErrors.setText("Service Errors: " + players.get(playerSelected).getServiceErrors());
            }
        });
        middle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setter.setChecked(false);
                rightside.setChecked(false);
                middle.setChecked(true);
                outside.setChecked(false);
                leftback.setChecked(false);
                libero.setChecked(false);

                playerSelected = 2;

                dispHitts.setText("Hits: " + players.get(playerSelected).getHits());
                dispBlocks.setText("Blocks: " + players.get(playerSelected).getBlocks());
                dispKills.setText("Kills: " + players.get(playerSelected).getKills());
                dispTips.setText("Tips: " + players.get(playerSelected).getTips());
                dispDigs.setText("Digs: " + players.get(playerSelected).getDigs());
                dispPass.setText("Passes: " + players.get(playerSelected).getPasses());
                dispSets.setText("Sets: " + players.get(playerSelected).getSets());
                dispAces.setText("Aces: " + players.get(playerSelected).getAces());
                dispServes.setText("Serves: " + players.get(playerSelected).getServes());
                dispAssists.setText("Assists: " + players.get(playerSelected).getAssists());
                dispPoints.setText("Points: " + players.get(playerSelected).getPoints());
                dispServiceErrors.setText("Service Errors: " + players.get(playerSelected).getServiceErrors());
            }
        });
        outside.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setter.setChecked(false);
                rightside.setChecked(false);
                middle.setChecked(false);
                outside.setChecked(true);
                leftback.setChecked(false);
                libero.setChecked(false);

                playerSelected = 3;

                dispHitts.setText("Hits: " + players.get(playerSelected).getHits());
                dispBlocks.setText("Blocks: " + players.get(playerSelected).getBlocks());
                dispKills.setText("Kills: " + players.get(playerSelected).getKills());
                dispTips.setText("Tips: " + players.get(playerSelected).getTips());
                dispDigs.setText("Digs: " + players.get(playerSelected).getDigs());
                dispPass.setText("Passes: " + players.get(playerSelected).getPasses());
                dispSets.setText("Sets: " + players.get(playerSelected).getSets());
                dispAces.setText("Aces: " + players.get(playerSelected).getAces());
                dispServes.setText("Serves: " + players.get(playerSelected).getServes());
                dispAssists.setText("Assists: " + players.get(playerSelected).getAssists());
                dispPoints.setText("Points: " + players.get(playerSelected).getPoints());
                dispServiceErrors.setText("Service Errors: " + players.get(playerSelected).getServiceErrors());
            }
        });
        leftback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setter.setChecked(false);
                rightside.setChecked(false);
                middle.setChecked(false);
                outside.setChecked(false);
                leftback.setChecked(true);
                libero.setChecked(false);

                playerSelected = 4;

                dispHitts.setText("Hits: " + players.get(playerSelected).getHits());
                dispBlocks.setText("Blocks: " + players.get(playerSelected).getBlocks());
                dispKills.setText("Kills: " + players.get(playerSelected).getKills());
                dispTips.setText("Tips: " + players.get(playerSelected).getTips());
                dispDigs.setText("Digs: " + players.get(playerSelected).getDigs());
                dispPass.setText("Passes: " + players.get(playerSelected).getPasses());
                dispSets.setText("Sets: " + players.get(playerSelected).getSets());
                dispAces.setText("Aces: " + players.get(playerSelected).getAces());
                dispServes.setText("Serves: " + players.get(playerSelected).getServes());
                dispAssists.setText("Assists: " + players.get(playerSelected).getAssists());
                dispPoints.setText("Points: " + players.get(playerSelected).getPoints());
                dispServiceErrors.setText("Service Errors: " + players.get(playerSelected).getServiceErrors());
            }
        });
        libero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setter.setChecked(false);
                rightside.setChecked(false);
                middle.setChecked(false);
                outside.setChecked(false);
                leftback.setChecked(false);
                libero.setChecked(true);

                playerSelected = 5;

                dispHitts.setText("Hits: " + players.get(playerSelected).getHits());
                dispBlocks.setText("Blocks: " + players.get(playerSelected).getBlocks());
                dispKills.setText("Kills: " + players.get(playerSelected).getKills());
                dispTips.setText("Tips: " + players.get(playerSelected).getTips());
                dispDigs.setText("Digs: " + players.get(playerSelected).getDigs());
                dispPass.setText("Passes: " + players.get(playerSelected).getPasses());
                dispSets.setText("Sets: " + players.get(playerSelected).getSets());
                dispAces.setText("Aces: " + players.get(playerSelected).getAces());
                dispServes.setText("Serves: " + players.get(playerSelected).getServes());
                dispAssists.setText("Assists: " + players.get(playerSelected).getAssists());
                dispPoints.setText("Points: " + players.get(playerSelected).getPoints());
                dispServiceErrors.setText("Service Errors: " + players.get(playerSelected).getServiceErrors());
            }
        });
    }

    public void addHit(){
        Button addbtn = (Button) findViewById(R.id.addHits);

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textDisplay = (TextView)findViewById(R.id.dispHit);
                players.get(playerSelected).increaseHit();
                textDisplay.setText("Hits: " + players.get(playerSelected).getHits());

            }
        });
    }

    public void addBlock(){
        Button addBtn = (Button) findViewById(R.id.addBlocks);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textDisplay = (TextView)findViewById(R.id.dispBlock);

                players.get(playerSelected).increaseBlock();
                textDisplay.setText("Blocks: " + players.get(playerSelected).getBlocks());

            }
        });
    }

    public void addKills(){
        Button addBtn = (Button) findViewById(R.id.addKills);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textDisplay = (TextView)findViewById(R.id.dispKill);
                players.get(playerSelected).increaseKill();
                textDisplay.setText("Kills: " + players.get(playerSelected).getKills());

            }
        });
    }

    public void addTips(){
        Button addBtn = (Button) findViewById(R.id.addTips);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textDisplay = (TextView)findViewById(R.id.dispTips);
//                int hitNum = Integer.parseInt(textDisplay.getText().toString().substring(6));
//                System.out.println(Integer.parseInt(textDisplay.getText().toString().substring(6)));
//                players.get(1).setHits(hitNum);
                players.get(playerSelected).increaseTip();
                textDisplay.setText("Tips: " + players.get(playerSelected).getTips());

            }
        });
    }

    public void addDig(){
        Button addBtn = (Button) findViewById(R.id.addDigs);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textDisplay = (TextView)findViewById(R.id.dispDigs);
                players.get(playerSelected).increaseDig();
                textDisplay.setText("Digs: " + players.get(playerSelected).getDigs());

            }
        });
    }

    public void addPasses(){
        Button addBtn = (Button) findViewById(R.id.addPasses);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textDisplay = (TextView)findViewById(R.id.dispPasses);
                players.get(playerSelected).increasePass();
                textDisplay.setText("Passes: " + players.get(playerSelected).getPasses());
            }
        });
    }

    public void addSets(){
        Button addBtn = (Button) findViewById(R.id.addSets);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textDisplay = (TextView)findViewById(R.id.dispSets);
                players.get(playerSelected).increaseSets();
                textDisplay.setText("Sets: " + players.get(playerSelected).getSets());

            }
        });
    }

    public void addAces(){
        Button addBtn = (Button) findViewById(R.id.addAces);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textDisplay = (TextView)findViewById(R.id.dispAces);
                players.get(playerSelected).increaseAce();
                textDisplay.setText("Aces: " + players.get(playerSelected).getAces());

            }
        });
    }

    public void addServes(){
        Button addBtn = (Button) findViewById(R.id.addServes);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textDisplay = (TextView)findViewById(R.id.dispServes);
                players.get(playerSelected).increaseServe();
                textDisplay.setText("Serves: " + players.get(playerSelected).getServes());

            }
        });
    }

    public void addAssist(){
        Button addBtn = (Button) findViewById(R.id.addAssists);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textDisplay = (TextView)findViewById(R.id.dispAssists);
                players.get(playerSelected).increaseAssist();
                textDisplay.setText("Assists: " + players.get(playerSelected).getAssists());

            }
        });
    }

    public void addPoints(){
        Button addBtn = (Button) findViewById(R.id.addPoints);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textDisplay = (TextView)findViewById(R.id.dispPoints);
                players.get(playerSelected).increasePoints();
                textDisplay.setText("Points: " + players.get(playerSelected).getPoints());

            }
        });
    }

    public void addServiceErrors(){
        Button addBtn = (Button) findViewById(R.id.addServiceErrors);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textDisplay = (TextView)findViewById(R.id.dispServiceErrors);
                players.get(playerSelected).increaseServiceErrors();
                textDisplay.setText("Service Errors: " + players.get(playerSelected).getServiceErrors());

            }
        });
    }

    public void saveText(){
        Button buttonSave = findViewById(R.id.saveScore);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textDisplay = findViewById(R.id.dispHit);


                //EditText text = findViewById(R.id.enterScore);
                String textToSave = textDisplay.getText().toString().substring(6);

//                String textToSave = text.getText().toString();

                try {
                    FileOutputStream fos = openFileOutput(FILE1, Context.MODE_PRIVATE);
                    fos.write(textToSave.getBytes());
                    fos.write("\n".getBytes());
//                    fos.write(",".getBytes());
                    fos.close();
                } catch (Exception e){
                    textDisplay.setText("file save error");
                }

            }
        });

    }

    public void loadFile(){
        Button loadButton = findViewById(R.id.loadScore);
        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textError = findViewById(R.id.dispHit);
                try {
                    TextView loadedText = findViewById(R.id.dispHit);
                    loadedText.setText("Hits: ");

                    FileInputStream fis = openFileInput(FILE1);

                    BufferedReader reader = new BufferedReader(new InputStreamReader(new DataInputStream(fis)));

                    String line;

                    while ((line = reader.readLine()) != null){
                        loadedText.append(line);
                        //loadedText.append("\n");
                    }

                    fis.close();
                }catch (Exception e){
                    textError.setText("file load failed");
                }
            }
        });
    }

}
