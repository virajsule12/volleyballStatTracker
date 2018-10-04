package com.example.rc211.volleyballstattracker;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Storage extends AppCompatActivity {
    private static final String FILE = "playerStats.txt";

    public Storage(){
        saveText();
    }

    public void saveText(){



                //EditText text = findViewById(R.id.enterScore);
                String textToSave = "hello world TEST";

//                String textToSave = text.getText().toString();

                try {
                    FileOutputStream fos = openFileOutput(FILE, Context.MODE_PRIVATE);
                    fos.write(textToSave.getBytes());
                    fos.write("\n".getBytes());
//                    fos.write(",".getBytes());
                    fos.close();
                } catch (Exception e){
                    System.out.println("file save error");
                }



    }

    public String loadFile(int stat){
        try {

            String loadedStats = "";

            FileInputStream fis = openFileInput(FILE);

            BufferedReader reader = new BufferedReader(new InputStreamReader(new DataInputStream(fis)));

            String line;

            while ((line = reader.readLine()) != null){
//                loadedStats.append(line);
                loadedStats = loadedStats + line;
                //loadedText.append("\n");
            }

            fis.close();

            return loadedStats;
        }catch (Exception e){
            return ("File load error");
        }
    }
}
