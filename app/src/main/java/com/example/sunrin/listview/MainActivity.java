package com.example.sunrin.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
private ListView listview;
private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new CustomAdapter();

        listview = (ListView) findViewById(R.id.listview);

        listview.setAdapter(adapter);

        adapter.add("Civilization V");
        adapter.add("Starcraft");
        adapter.add("Call of Duty");
        adapter.add("BattleField");
        adapter.add("Sim City");
        adapter.add("Fallout");
    }
}
