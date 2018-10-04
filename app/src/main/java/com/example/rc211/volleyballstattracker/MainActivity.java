package com.example.rc211.volleyballstattracker;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static com.example.rc211.volleyballstattracker.NewGameActivity.FILE1;

public class MainActivity extends AppCompatActivity {

    private List<Storage> files = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeFiles();

        startNewGame();
        loadGraph();

//        GraphView graph = (GraphView) findViewById(R.id.graph);
//        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
//                new DataPoint(0, 3),
//                new DataPoint(1, 5),
//                new DataPoint(2, 3),
//                new DataPoint(3, 2),
//                new DataPoint(4, 6)
//        });
//
//        LineGraphSeries<DataPoint> stuff = new LineGraphSeries<>();
//        series.appendData(new DataPoint(5,2), false,1 );
//
//        graph.addSeries(series);



    }

    public void initializeFiles(){
        files.add(new Storage());
        files.add(new Storage());
        files.add(new Storage());
        files.add(new Storage());
        files.add(new Storage());
        files.add(new Storage());

        String text = files.get(0).loadFile(0);
        TextView textView = findViewById(R.id.dispStats);
        textView.setText(text);

    }

    public void startNewGame(){
        Button startNewGame = findViewById(R.id.newGame);
        startNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchGame();
            }
        });
    }

    public void loadGraph(){
        Button loadGraphbtn = findViewById(R.id.testBtn);
        loadGraphbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFile();
            }
        });
    }

    public void launchGame(){
        Intent startNewGame = new Intent(this, NewGameActivity.class);
        startActivity(startNewGame);
    }

    public void loadFile(){
                TextView textError = findViewById(R.id.dispHit);
                try {
                    String dataPoints ="";



                    FileInputStream fis = openFileInput(FILE1);

                    BufferedReader reader = new BufferedReader(new InputStreamReader(new DataInputStream(fis)));

                    String line;

                    GraphView graph = (GraphView) findViewById(R.id.graph);
                    DataPoint[] x = new DataPoint[3];
                    LineGraphSeries<DataPoint> points = new LineGraphSeries<>(x);


                    int counter =1;
                    while ((line = reader.readLine()) != null){
                        if (!line.equals(" ")){
                            x[counter-1] = new DataPoint(counter,Integer.parseInt(line));
                            //points.appendData(new DataPoint(counter,Integer.parseInt(line)),true,1);
                            counter++;
                        }
                        else {
                            graph.addSeries(points);
                        }
                    }

                    fis.close();
                }catch (Exception e){
                    System.out.println("file load failed");;
                }
    }

}
