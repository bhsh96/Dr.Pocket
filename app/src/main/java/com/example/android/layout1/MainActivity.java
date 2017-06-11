package com.example.android.layout1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView cancerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cancerList = (ListView) findViewById(R.id.categories);

        List<String> list = new ArrayList<>();
        try {
            InputStream in = getAssets().open("categories.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            String buff;

            while ((buff = reader.readLine()) != null) {
                list.add(buff);
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        cancerList.setAdapter(myArrayAdapter);

        cancerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getBaseContext(), ShowPageActivity.class);
                String selectedFromList = (cancerList.getItemAtPosition(position).toString());
                intent.putExtra("selected", selectedFromList);
                startActivity(intent);
            }
        });
    }




}
