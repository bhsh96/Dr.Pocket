package com.example.android.layout1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ShowPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_page);

        //Get Intent
        Intent intent = getIntent();
        String message = intent.getStringExtra("selected");

        TextView textView = (TextView) findViewById(R.id.infoPage);


        try {
            InputStream in = getAssets().open(message + ".txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            String buff;

            while ((buff = reader.readLine()) != null) {
                textView.append("   " + buff + "\n");
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
