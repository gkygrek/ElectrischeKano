package com.example.onno.testapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

public class Main7Activity extends AppCompatActivity {

    BarChart barChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        barChart = (BarChart)findViewById(R.id.barChart);
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(44f,0));
        barEntries.add(new BarEntry(12f,1));
        barEntries.add(new BarEntry(72f,2));
        barEntries.add(new BarEntry(44f,3));
        barEntries.add(new BarEntry(44f,4));

        barChart = (BarChart)findViewById(R.id.barChart);
        ArrayList<BarEntry> barEntry2 = new ArrayList<>();
        barEntry2.add(new BarEntry(20f,0));
        barEntry2.add(new BarEntry(20f,1));
        barEntry2.add(new BarEntry(20f,2));
        barEntry2.add(new BarEntry(20f,3));
        barEntry2.add(new BarEntry(20f,4));

        BarDataSet set1 = new BarDataSet(barEntries,"Stolen bikes");
        set1.setColor(-65536);
        BarDataSet set2 = new BarDataSet(barEntry2,"Bike Trommels");
        set2.setColor(-16711012);

        ArrayList<String> hoodList = new ArrayList<>();
        hoodList.add("Delfshaven");
        hoodList.add("Rotje");
        hoodList.add("Knor");
        hoodList.add("Liskwart");
        hoodList.add("Centrum");

        ArrayList<BarDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);
        dataSets.add(set2);


        BarData data = new BarData(hoodList, set2);
        data.addDataSet(set1);
        barChart.setData(data);
        barChart.invalidate();
        barChart.setDrawBarShadow(true);

        barChart.setTouchEnabled(true);
        barChart.setScaleEnabled(true);
        barChart.setDragEnabled(true);
    }

}
