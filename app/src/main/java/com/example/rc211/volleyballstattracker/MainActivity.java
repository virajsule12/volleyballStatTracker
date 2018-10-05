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

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static com.example.rc211.volleyballstattracker.NewGameActivity.FILE1;

public class MainActivity extends AppCompatActivity {

    public static final String FILE1 = "player1Stats.txt";
    public static final String FILE2 = "player2Stats.txt";
    public static final String FILE3 = "player3Stats.txt";
    public static final String FILE4 = "player4Stats.txt";
    public static final String FILE5 = "player5Stats.txt";
    public static final String FILE6 = "player6Stats.txt";
    public static final String TESTFILE1 = "testfile1.txt";

    private List<Storage> stats = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stats.add(new Storage());
        stats.add(new Storage());
        stats.add(new Storage());
        stats.add(new Storage());
        stats.add(new Storage());
        stats.add(new Storage());

        initializeStats();

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





//    public void saveText(){
//        //EditText text = findViewById(R.id.enterScore);
//        String textToSave = "hello world TEST";
//
////                String textToSave = text.getText().toString();
//
//        try {
//            FileOutputStream fos = openFileOutput(FILE, Context.MODE_PRIVATE);
//            fos.write(textToSave.getBytes());
//            fos.write("\n".getBytes());
////                    fos.write(",".getBytes());
//            fos.close();
//        } catch (Exception e){
//            System.out.println("file save error");
//        }
//    }
//
//    public String loadFile(int stat){
//        try {
//
//            String loadedStats = "";
//
//            FileInputStream fis = openFileInput(FILE);
//
//            BufferedReader reader = new BufferedReader(new InputStreamReader(new DataInputStream(fis)));
//
//            String line;
//
//            while ((line = reader.readLine()) != null){
////                loadedStats.append(line);
//                loadedStats = loadedStats + line;
//                //loadedText.append("\n");
//            }
//
//            fis.close();
//
//            return loadedStats;
//        }catch (Exception e){
//            return ("File load error");
//        }
//    }





    public void initializeStats(){
//        for (int i = 0;i < 12;i++){
            String textToSave = "0\n1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11";

//                String textToSave = text.getText().toString();

            try {
                FileOutputStream fos = openFileOutput(TESTFILE1, Context.MODE_PRIVATE);
//                fos.write(textToSave.getBytes());
//                for (int i=0;i<12;i++){
//                    fos.write(textToSave.substring(i,i+1).getBytes());
//                    fos.write("\n".getBytes());
//                }
//                fos.write("\n".getBytes());
//                fos.write("\n".getBytes());
//                fos.write("\n".getBytes());

//                fos.write("\n".getBytes());
                fos.write("\n0\n1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11".getBytes());
//                fos.write("\n".getBytes());
//                fos.write("1".getBytes());
//                fos.write("\n".getBytes());

//                //fos.write("\n".getBytes());
//                    fos.write(",".getBytes());
                fos.close();
            } catch (Exception e){
                EditText text = findViewById(R.id.dispStats2);
                text.setText("file save unsuccesfull");
            }
//        }



        try {

            String loadedStats = "";

            FileInputStream fis = openFileInput(TESTFILE1);

            BufferedReader reader = new BufferedReader(new InputStreamReader(new DataInputStream(fis)));

            String line = "";
            line = reader.readLine();

            EditText text = findViewById(R.id.dispStats2);

//            text1.setText(line);
            String newText = "";

//            for (int i = 0;i < 12;i++){
                while ((line = reader.readLine()) != null){
//                    newText = newText + line;
//                    text.append("\n"+line);

                    stats.get(0).addStats(line);
//                    text.append("line " + line);
                }
//            }

//            text.setText(newText);
            fis.close();

        }catch (Exception e){
            EditText textError = findViewById(R.id.dispStats);
            textError.setText("FILE LOAD ERROR!");
        }

        EditText text = findViewById(R.id.dispStats2);
        for (int i = 0;i < 12;i++){
            text.append("yo: "+stats.get(0).getStats(i)+ "\n");
        }


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
