package com.example.rc211.volleyballstattracker;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

    List<Player> players = new ArrayList<>();

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

        addHit();
        addBlock();
        addKills();
        addTips();
        addDig();
        addPasses();
        addSets();

        saveText();
        loadFile();
    }

    public void addHit(){
        Button addbtn = (Button) findViewById(R.id.addHits);

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textDisplay = (TextView)findViewById(R.id.dispHit);
//                int hitNum = Integer.parseInt(textDisplay.getText().toString().substring(6));
//                System.out.println(Integer.parseInt(textDisplay.getText().toString().substring(6)));
//                players.get(1).setHits(hitNum);
                players.get(0).increaseHit();
                textDisplay.setText("Hits: " + players.get(0).getHits());

            }
        });
    }

    public void addBlock(){
        Button addBtn = (Button) findViewById(R.id.addBlocks);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textDisplay = (TextView)findViewById(R.id.dispBlock);
//                int hitNum = Integer.parseInt(textDisplay.getText().toString().substring(6));
//                System.out.println(Integer.parseInt(textDisplay.getText().toString().substring(6)));
//                players.get(1).setHits(hitNum);
                players.get(0).increaseBlock();
                textDisplay.setText("Blocks: " + players.get(0).getBlocks());

            }
        });
    }

    public void addKills(){
        Button addBtn = (Button) findViewById(R.id.addKills);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textDisplay = (TextView)findViewById(R.id.dispKill);
//                int hitNum = Integer.parseInt(textDisplay.getText().toString().substring(6));
//                System.out.println(Integer.parseInt(textDisplay.getText().toString().substring(6)));
//                players.get(1).setHits(hitNum);
                players.get(0).increaseKill();
                textDisplay.setText("Kills: " + players.get(0).getKills());

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
                players.get(0).increaseTip();
                textDisplay.setText("Kills: " + players.get(0).getTips());

            }
        });
    }

    public void addDig(){
        Button addBtn = (Button) findViewById(R.id.addDigs);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textDisplay = (TextView)findViewById(R.id.dispDigs);
//                int hitNum = Integer.parseInt(textDisplay.getText().toString().substring(6));
//                System.out.println(Integer.parseInt(textDisplay.getText().toString().substring(6)));
//                players.get(1).setHits(hitNum);
                players.get(0).increaseDig();
                textDisplay.setText("Kills: " + players.get(0).getDigs());

            }
        });
    }

    public void addPasses(){
        Button addBtn = (Button) findViewById(R.id.addPasses);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textDisplay = (TextView)findViewById(R.id.dispPasses);
//                int hitNum = Integer.parseInt(textDisplay.getText().toString().substring(6));
//                System.out.println(Integer.parseInt(textDisplay.getText().toString().substring(6)));
//                players.get(1).setHits(hitNum);
                players.get(0).increasePass();
                textDisplay.setText("Kills: " + players.get(0).getPasses());

            }
        });
    }

    public void addSets(){
        Button addBtn = (Button) findViewById(R.id.addSets);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textDisplay = (TextView)findViewById(R.id.dispSets);
//                int hitNum = Integer.parseInt(textDisplay.getText().toString().substring(6));
//                System.out.println(Integer.parseInt(textDisplay.getText().toString().substring(6)));
//                players.get(1).setHits(hitNum);
                players.get(0).increaseSets();
                textDisplay.setText("Kills: " + players.get(0).getSets());

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
                    fos.write(",".getBytes());
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
