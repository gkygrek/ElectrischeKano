package com.example.onno.testapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    List<String> voorvalNummerList = new ArrayList<String>();
    List<String> kennisNameList = new ArrayList<String>();
    List<String> MKList = new ArrayList<String>();
    List<String> MKOmschrijvingList = new ArrayList<String>();
    List<String> pogingList = new ArrayList<String>();
    List<String> districtList = new ArrayList<String>();
    List<String> werkgebiedList = new ArrayList<String>();
    List<String> plaatsList = new ArrayList<String>();
    List<String> buurtList = new ArrayList<String>();
    List<String> straatList = new ArrayList<String>();
    List<String> beginDagsoortList = new ArrayList<String>();
    List<String> beginDatumList = new ArrayList<String>();
    List<String> beginTijdList = new ArrayList<String>();
    List<String> eindDagsoortList = new ArrayList<String>();
    List<String> eindDatumList = new ArrayList<String>();
    List<String> eindTijd = new ArrayList<String>();
    List<String> gemiddeldeJaarList = new ArrayList<String>();
    List<String> gemiddeldeMaandList = new ArrayList<String>();
    List<String> gemiddeldeDagsoortList = new ArrayList<String>();
    List<String> gemiddeldeDagdeelList = new ArrayList<String>();
    List<String> TrefwoordList = new ArrayList<String>();
    List<String> objectList = new ArrayList<String>();
    List<String> merkList = new ArrayList<String>();
    List<String> typeList = new ArrayList<String>();
    List<String> kleurList = new ArrayList<String>();

    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button buttonPieChart = (Button) findViewById(R.id.buttonPieChart);
        Button buttonLineChart = (Button) findViewById(R.id.buttonLineChart);
        Button buttonBarChart = (Button) findViewById(R.id.buttonBarChart);
        Button buttonNeighbouurhoudChart = (Button) findViewById(R.id.buttonNeighbouurhoudChart);
        context = this.getApplicationContext();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        buttonPieChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,Main5Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });


        buttonLineChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,Main6Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        buttonBarChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,Main7Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        buttonNeighbouurhoudChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,Main8Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

        InputStream inputStream = getResources().openRawResource(R.raw.fietsdiefstaldata);
        CSVReader csv = new CSVReader(inputStream);
        List<String[]> dataList = csv.read();

        List[] lists = {voorvalNummerList, kennisNameList, MKList, MKOmschrijvingList, pogingList,
                districtList, werkgebiedList, plaatsList, buurtList, straatList, beginDagsoortList, beginDatumList,
                beginTijdList, eindDagsoortList, eindDatumList, eindTijd, gemiddeldeJaarList, gemiddeldeMaandList, gemiddeldeDagsoortList,
                gemiddeldeDagdeelList, TrefwoordList, objectList, merkList, typeList, kleurList
        };

        Integer index = 0;
        for (Integer i = 0; i < dataList.size() ; i++) {
            String[] data = dataList.get(i);
            for (Integer y = 0 ; y < data.length ; y++) {
                if (index <= 24)
                    lists[index].add(data[y]);
                index++;
            }
            index = 0;
        }

        for (Integer i = 0 ; i < lists.length ; i++) {
            System.out.println("List sizes: " +  lists[i].size());
        }

        List<String> list = lists[24];
        for (Integer i = 0 ; i < list.size() ; i++) {
            System.out.println(list.get(i));
        }
    }

}
