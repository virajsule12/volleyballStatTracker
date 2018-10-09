package com.example.rc211.volleyballstattracker;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//import static com.example.rc211.volleyballstattracker.NewGameActivity.FILE1;

public class MainActivity extends AppCompatActivity {

    public static final String FILE1 = "player1Stats.txt";
    public static final String FILE2 = "player2Stats.txt";
    public static final String FILE3 = "player3Stats.txt";
    public static final String FILE4 = "player4Stats.txt";
    public static final String FILE5 = "player5Stats.txt";
    public static final String FILE6 = "player6Stats.txt";

    /*
    * TEXT FILE FORMAT:
    * x,x,x,x,x,x,x,x,x,x,x,x,x,x,
    * times 12 because there are 12 stats
    * 6 files, one for each player position
    * */

    private List<Storage> stats = new ArrayList<>();//object array that saves stats from text files; new data is added each object and then saved into a text file

    private boolean filesDisplayed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {//initializes stats object array; calls any necessary methods so that the app can start correctly
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

        loadHitsGraph();

        loadBlocksGraph();

        displayFiles();


//        loadGraph();

//        GraphView graph = (GraphView) findViewById(R.id.graph);
////        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
////                new DataPoint(0, 3),
////                new DataPoint(1, 5),
////                new DataPoint(2, 3),
////                new DataPoint(3, 2),
////                new DataPoint(4, 6)
////        });
////
////        LineGraphSeries<DataPoint> stuff = new LineGraphSeries<>();
////        series.appendData(new DataPoint(5,2), false,1 );
////
////        graph.addSeries(series);



    }

    public void loadBlocksGraph(){
        String hits0 = stats.get(0).getStats(1);

        String [] arr0 = hits0.split(",");
        int total0 =0;
        for (String x : arr0){
            total0 += Integer.parseInt(x);
        }



        String hits1 = stats.get(1).getStats(1);

        String [] arr1 = hits1.split(",");
        int total1 =0;
        for (String x : arr1){
            total1 += Integer.parseInt(x);
        }



        String hits2 = stats.get(2).getStats(1);

        String [] arr2 = hits2.split(",");
        int total2 =0;
        for (String x : arr2){
            total2 += Integer.parseInt(x);
        }




        String hits3 = stats.get(3).getStats(1);

        String [] arr3 = hits3.split(",");
        int total3 =0;
        for (String x : arr3){
            total3 += Integer.parseInt(x);
        }




        String hits4 = stats.get(4).getStats(1);

        String [] arr4 = hits4.split(",");
        int total4 =0;
        for (String x : arr4){
            total4 += Integer.parseInt(x);
        }




        String hits5 = stats.get(5).getStats(1);

        String [] arr5 = hits5.split(",");
        int total5 =0;
        for (String x : arr5){
            total5 += Integer.parseInt(x);
        }




        GraphView graph = (GraphView) findViewById(R.id.graph2);
        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[]{});
        series.appendData(new DataPoint(0,0),false,100);
        series.appendData(new DataPoint(1,total0/arr0.length),false,100);
        series.appendData(new DataPoint(2,total1/arr1.length),false,100);
        series.appendData(new DataPoint(3,total2/arr2.length),false,100);
        series.appendData(new DataPoint(4,total3/arr3.length),false,100);
        series.appendData(new DataPoint(5,total4/arr4.length),false,100);
        series.appendData(new DataPoint(6,total5/arr5.length),false,100);

//        graph.getViewport().setMinX(0);
//        graph.getViewport().setMinY(0);

        graph.addSeries(series);
        series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                return Color.rgb((int) data.getX()*255/6, (int) Math.abs(data.getY()*255/6), 100);
            }
        });

        series.setSpacing(50);

        series.setDrawValuesOnTop(true);
        series.setValuesOnTopColor(Color.RED);
        series.setTitle("Avg Blocks per Player");
        graph.getLegendRenderer().setVisible(true);
        graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);



    }

    public void loadHitsGraph(){

        ArrayList<Integer> hitStats = new ArrayList<>();
        String hits0 = stats.get(0).getStats(0);

        String [] arr0 = hits0.split(",");
        int total0 =0;
        for (String x : arr0){
            total0 += Integer.parseInt(x);
        }
        hitStats.add(total0);



        String hits1 = stats.get(1).getStats(0);

        String [] arr1 = hits1.split(",");
        int total1 =0;
        for (String x : arr1){
            total1 += Integer.parseInt(x);
        }
        hitStats.add(total1);



        String hits2 = stats.get(2).getStats(0);

        String [] arr2 = hits2.split(",");
        int total2 =0;
        for (String x : arr2){
            total2 += Integer.parseInt(x);
        }
        hitStats.add(total2);



        String hits3 = stats.get(3).getStats(0);

        String [] arr3 = hits3.split(",");
        int total3 =0;
        for (String x : arr3){
            total3 += Integer.parseInt(x);
        }
        hitStats.add(total3);



        String hits4 = stats.get(4).getStats(0);

        String [] arr4 = hits4.split(",");
        int total4 =0;
        for (String x : arr4){
            total4 += Integer.parseInt(x);
        }
        hitStats.add(total4);



        String hits5 = stats.get(5).getStats(0);

        String [] arr5 = hits5.split(",");
        int total5 =0;
        for (String x : arr5){
            total5 += Integer.parseInt(x);
        }
        hitStats.add(total5);

//        DataPoint[] dataPoints = new DataPoint[6];
//        dataPoints[0] = new DataPoint(0,total0/arr0.length);
//        dataPoints[1] = new DataPoint(1,total1/arr1.length);
//        dataPoints[2] = new DataPoint(2,total2/arr2.length);
//        dataPoints[3] = new DataPoint(3,total3/arr3.length);
//        dataPoints[4] = new DataPoint(4,total4/arr4.length);
//        dataPoints[5] = new DataPoint(5,total5/arr5.length);

        GraphView graph = (GraphView) findViewById(R.id.graph);
        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[]{});
//        System.out.println("5" + total5);
//        System.out.println(arr0.length);
        series.appendData(new DataPoint(0,0),false,100);
        series.appendData(new DataPoint(1,total0/arr0.length),false,100);
        series.appendData(new DataPoint(2,total1/arr1.length),false,100);
        series.appendData(new DataPoint(3,total2/arr2.length),false,100);
        series.appendData(new DataPoint(4,total3/arr3.length),false,100);
        series.appendData(new DataPoint(5,total4/arr4.length),false,100);
        series.appendData(new DataPoint(6,total5/arr5.length),false,100);

//        graph.getViewport().setMinX(0);
//        graph.getViewport().setMinY(0);

        graph.addSeries(series);
        series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                return Color.rgb((int) data.getX()*255/6, (int) Math.abs(data.getY()*255/6), 100);
            }
        });

        series.setSpacing(50);

        series.setDrawValuesOnTop(true);
        series.setValuesOnTopColor(Color.RED);
        series.setTitle("Avg Hits per Player");
        graph.getLegendRenderer().setVisible(true);
        graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);



    }

    public void initializeStats(){//loads text file data into Storage objects
        //TEMPLATE FOR ADDING DUMMY DATA TO A TEXT FILE
//        try {
//            FileOutputStream fos = openFileOutput(FILEX, Context.MODE_PRIVATE);
//            fos.write("0,2,3,3,4,5,6,10,22,6,\n1,3,5,4,3,3,3,8,7,8,\n2,2,3,6,5,4,3,4,8,9,\n3,6,5,4,3,8,7,6,5,15,\n4,1,14,3,2,7,9,6,5,4,\n5,3,2,5,6,8,9,6,5,12,\n6,3,17,3,4,2,1,5,6,8,\n7,1,1,2,3,6,4,5,7,13,\n8,4,3,5,7,6,5,5,5,3,\n9,1,2,1,3,6,4,3,6,5,\n10,2,6,4,4,6,8,1,2,10,\n11,7,6,4,3,6,5,7,8,2,".getBytes());
//            fos.close();
//        } catch (Exception e){
//            EditText text = findViewById(R.id.dispStats);
//            text.setText("file save unsuccessful");
//        }


        try {
            FileInputStream fis = openFileInput(FILE1);
            BufferedReader reader = new BufferedReader(new InputStreamReader(new DataInputStream(fis)));
            String line = "";


            while ((line = reader.readLine()) != null){
                stats.get(0).addStats(line);
            }

            fis.close();

        }catch (Exception e){
            EditText textError = findViewById(R.id.dispStats);
            textError.setText("FILE LOAD ERROR!");
        }

        try {
            FileInputStream fis = openFileInput(FILE2);
            BufferedReader reader = new BufferedReader(new InputStreamReader(new DataInputStream(fis)));
            String line = "";


            while ((line = reader.readLine()) != null){
                stats.get(1).addStats(line);
            }

            fis.close();

        }catch (Exception e){
            EditText textError = findViewById(R.id.dispStats);
            textError.setText("FILE LOAD ERROR!");
        }

        try {
            FileInputStream fis = openFileInput(FILE3);
            BufferedReader reader = new BufferedReader(new InputStreamReader(new DataInputStream(fis)));
            String line = "";


            while ((line = reader.readLine()) != null){
                stats.get(2).addStats(line);
            }

            fis.close();

        }catch (Exception e){
            EditText textError = findViewById(R.id.dispStats);
            textError.setText("FILE LOAD ERROR!");
        }

        try {
            FileInputStream fis = openFileInput(FILE4);
            BufferedReader reader = new BufferedReader(new InputStreamReader(new DataInputStream(fis)));
            String line = "";


            while ((line = reader.readLine()) != null){
                stats.get(3).addStats(line);
            }

            fis.close();

        }catch (Exception e){
            EditText textError = findViewById(R.id.dispStats);
            textError.setText("FILE LOAD ERROR!");
        }

        try {
            FileInputStream fis = openFileInput(FILE5);
            BufferedReader reader = new BufferedReader(new InputStreamReader(new DataInputStream(fis)));
            String line = "";


            while ((line = reader.readLine()) != null){
                stats.get(4).addStats(line);
            }

            fis.close();

        }catch (Exception e){
            EditText textError = findViewById(R.id.dispStats);
            textError.setText("FILE LOAD ERROR!");
        }

        try {
            FileInputStream fis = openFileInput(FILE6);
            BufferedReader reader = new BufferedReader(new InputStreamReader(new DataInputStream(fis)));
            String line = "";


            while ((line = reader.readLine()) != null){
                stats.get(5).addStats(line);
            }

            fis.close();

        }catch (Exception e){
            EditText textError = findViewById(R.id.dispStats);
            textError.setText("FILE LOAD ERROR!");
        }


        //display data from text files after they have been
        EditText text = findViewById(R.id.dispStats);
        text.setText("");
        for (int i = 0;i < 12;i++){
            text.append("FILE1: " + stats.get(0).getStats(i)+ "\n");
        }
        text.append("\n");
        for (int i = 0;i < 12;i++){
            text.append("FILE2: " + stats.get(1).getStats(i)+ "\n");
        }
        text.append("\n");
        for (int i = 0;i < 12;i++){
            text.append("FILE3: " + stats.get(2).getStats(i)+ "\n");
        }
        text.append("\n");
        for (int i = 0;i < 12;i++){
            text.append("FILE4: " + stats.get(3).getStats(i)+ "\n");
        }
        text.append("\n");
        for (int i = 0;i < 12;i++){
            text.append("FILE5: " + stats.get(4).getStats(i)+ "\n");
        }
        text.append("\n");
        for (int i = 0;i < 12;i++){
            text.append("FILE6: " + stats.get(5).getStats(i)+ "\n");
        }
    }

    public void startNewGame(){//calls method which launches a new activity
        Button startNewGame = findViewById(R.id.newGame);
        startNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchGame();
            }
        });
    }

//    public void loadGraph(){
//        Button loadGraphbtn = findViewById(R.id.testBtn);
//        loadGraphbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                loadFile();
//            }
//        });
//    }

    public void launchGame(){//launches new activity with startActivityResult which is used to pass data back to MainActivity once the launched activity is finished
        Intent i = new Intent(this, NewGameActivity.class);
        startActivityForResult(i, 1);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {//method which gets data from a NewGameActivity once it finishes
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {//the finished NewGameActivity returns data in form of strings which are used as parameters for the saveFiles() method
                String newStats1 = data.getStringExtra("stats1");
                String newStats2 = data.getStringExtra("stats2");
                String newStats3 = data.getStringExtra("stats3");
                String newStats4 = data.getStringExtra("stats4");
                String newStats5 = data.getStringExtra("stats5");
                String newStats6 = data.getStringExtra("stats6");
                saveFiles(newStats1, newStats2, newStats3, newStats4, newStats5, newStats6);
                initializeStats();//after the data from NewGameActivity is saved to text files, it is then loaded again and added to Storage objects
            }
        }
    }

    public void saveFiles(String stats1, String stats2, String stats3, String stats4, String stats5, String stats6){//method which saves the new data from NewGameActivity to text files for each player

        stats.get(0).addNewStats(stats1);
        stats.get(1).addNewStats(stats2);
        stats.get(2).addNewStats(stats3);
        stats.get(3).addNewStats(stats4);
        stats.get(4).addNewStats(stats5);
        stats.get(5).addNewStats(stats6);



        EditText text = findViewById(R.id.dispStats);
        text.setText("STATS1: "+stats1);
        text.append("\nSTATS2: "+stats2);
        text.append("\nSTATS3: "+stats3);
        text.append("\nSTATS4: "+stats4);
        text.append("\nSTATS5: "+stats5);
        text.append("\nSTATS6: "+stats6);

        String textToSave = "";

        for (int i = 0;i < 12;i++){
            if (i == 0){
                textToSave = textToSave + stats.get(0).getStats(i);
            }
            else {
                textToSave = textToSave + "\n" + stats.get(0).getStats(i);
            }
        }

        text.setText("setText: " + textToSave);

        String textToSave2 = "";

        for (int i = 0;i < 12;i++){
            if (i == 0){
                textToSave2 = textToSave2 + stats.get(1).getStats(i);
            }
            else {
                textToSave2 = textToSave2 + "\n" + stats.get(1).getStats(i);
            }
        }

        text.setText("setText2: " + textToSave2);

        String textToSave3 = "";

        for (int i = 0;i < 12;i++){
            if (i == 0){
                textToSave3 = textToSave3 + stats.get(2).getStats(i);
            }
            else {
                textToSave3 = textToSave3 + "\n" + stats.get(2).getStats(i);
            }
        }

        text.setText("setText3: " + textToSave3);

        String textToSave4 = "";

        for (int i = 0;i < 12;i++){
            if (i == 0){
                textToSave4 = textToSave4 + stats.get(3).getStats(i);
            }
            else {
                textToSave4 = textToSave4 + "\n" + stats.get(3).getStats(i);
            }
        }

        text.setText("setText4: " + textToSave4);

        String textToSave5 = "";

        for (int i = 0;i < 12;i++){
            if (i == 0){
                textToSave5 = textToSave5 + stats.get(4).getStats(i);
            }
            else {
                textToSave5 = textToSave5 + "\n" + stats.get(4).getStats(i);
            }
        }

        text.setText("setText5: " + textToSave5);

        String textToSave6 = "";

        for (int i = 0;i < 12;i++){
            if (i == 0){
                textToSave6 = textToSave6 + stats.get(5).getStats(i);
            }
            else {
                textToSave6 = textToSave6 + "\n" + stats.get(5).getStats(i);
            }
        }

        text.setText("setText6: " + textToSave6);

        try {
            FileOutputStream fos = openFileOutput(FILE1, Context.MODE_PRIVATE);
            fos.write(textToSave.getBytes());
            fos.close();
        } catch (Exception e){
            text.setText("file save error!!!");
        }

        try {
            FileOutputStream fos = openFileOutput(FILE2, Context.MODE_PRIVATE);
            fos.write(textToSave2.getBytes());
            fos.close();
        } catch (Exception e){
            text.setText("file save error!!!");
        }

        try {
            FileOutputStream fos = openFileOutput(FILE3, Context.MODE_PRIVATE);
            fos.write(textToSave3.getBytes());
            fos.close();
        } catch (Exception e){
            text.setText("file save error!!!");
        }

        try {
            FileOutputStream fos = openFileOutput(FILE4, Context.MODE_PRIVATE);
            fos.write(textToSave4.getBytes());
            fos.close();
        } catch (Exception e){
            text.setText("file save error!!!");
        }

        try {
            FileOutputStream fos = openFileOutput(FILE5, Context.MODE_PRIVATE);
            fos.write(textToSave5.getBytes());
            fos.close();
        } catch (Exception e){
            text.setText("file save error!!!");
        }

        try {
            FileOutputStream fos = openFileOutput(FILE6, Context.MODE_PRIVATE);
            fos.write(textToSave6.getBytes());
            fos.close();
        } catch (Exception e){
            text.setText("file save error!!!");
        }

    }


    public void loadFile(){
                TextView textError = findViewById(R.id.dispHit);
                try {
                    String dataPoints ="";



                    FileInputStream fis = openFileInput(FILE1);

                    BufferedReader reader = new BufferedReader(new InputStreamReader(new DataInputStream(fis)));

                    String line;

                    //GraphView graph = (GraphView) findViewById(R.id.graph);
                    DataPoint[] x = new DataPoint[3];
                    //LineGraphSeries<DataPoint> points = new LineGraphSeries<>(x);


                    int counter =1;
                    while ((line = reader.readLine()) != null){
                        if (!line.equals(" ")){
                            x[counter-1] = new DataPoint(counter,Integer.parseInt(line));
                            //points.appendData(new DataPoint(counter,Integer.parseInt(line)),true,1);
                            counter++;
                        }
                        else {
                            //graph.addSeries(points);
                        }
                    }

                    fis.close();
                }catch (Exception e){
                    System.out.println("file load failed");;
                }
    }

    public void displayFiles(){
        final Button dispFiles = findViewById(R.id.dispFiles);
        dispFiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (filesDisplayed){
                    EditText dispFiles = findViewById(R.id.dispStats);
                    dispFiles.setVisibility(View.INVISIBLE);

                    GraphView graph = (GraphView) findViewById(R.id.graph2);
                    graph.setVisibility(View.VISIBLE);

                    filesDisplayed = false;

                    Button filesAndGraphs = findViewById(R.id.dispFiles);
                    filesAndGraphs.setText("FILES");
                }
                else {
                    EditText dispFiles = findViewById(R.id.dispStats);
                    dispFiles.setVisibility(View.VISIBLE);

                    GraphView graph = (GraphView) findViewById(R.id.graph2);
                    graph.setVisibility(View.INVISIBLE);

                    filesDisplayed = true;

                    Button filesAndGraphs = findViewById(R.id.dispFiles);
                    filesAndGraphs.setText("GRAPH");
                }
            }
        });
    }

}
