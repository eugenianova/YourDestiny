package com.example.pract.view;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.pract.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
    private final String TAG = this.getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if ("text/plain".equals(type)) {
                handleSendText(intent); // Handle text being sent
            }
        }
        app_specific_storage();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
        common_storage();



    }

    void handleSendText(Intent intent) {
        String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
        if (sharedText != null) {
            Log.d("MESSAGE_OUTSIDE", sharedText);
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        //startService(new Intent(this, FirstService.class));
    }
    @Override
    protected void onResume() {
        super.onResume();
        //stopService(new Intent(this, FirstService.class));
    }

    public void app_specific_storage(){
        Context context = getApplicationContext();
        String fileName = "example.txt";
        File directory = context.getFilesDir();
        System.out.println(getFilesDir().toString());;
        File file = new File(directory, fileName);
        try {
            FileWriter writer = new FileWriter(file);
            writer.append("Hello, world!");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileInputStream fis = null;
        try {
            fis = context.openFileInput("example.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        InputStreamReader inputStreamReader =
                null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            inputStreamReader = new InputStreamReader(fis, StandardCharsets.UTF_8);
        }
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
            String line = reader.readLine();
            while (line != null) {
                stringBuilder.append(line).append('\n');
                line = reader.readLine();
            }
        } catch (IOException e) {
        } finally {
            String contents = stringBuilder.toString();
            Log.d("Storages", contents);
        }
    }
    public void common_storage(){
        File directory = Environment.getExternalStorageDirectory();
        File file = new File(directory, "new_file.txt");
        try {
            FileWriter writer = new FileWriter(file);
            writer.write("Hello, world_2!");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        StringBuilder contentBuilder = new StringBuilder();
        directory.mkdirs();
        try {
            File file_2 = new File(directory,"new_file.txt");
            FileInputStream inputStream = new FileInputStream(file_2);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }

            reader.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String content = contentBuilder.toString();
        Log.d("Storages", content);
    }
}