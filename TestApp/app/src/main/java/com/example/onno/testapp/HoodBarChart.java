package com.example.onno.testapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Random;

public class HoodBarChart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BarChart barChart = (BarChart) findViewById(R.id.chart);
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(220f, 0));
        entries.add(new BarEntry(168f, 1));
        entries.add(new BarEntry(88f, 2));
        entries.add(new BarEntry(78f, 3));
        entries.add(new BarEntry(56f, 4));


        BarDataSet dataset = new BarDataSet(entries, "number of bike containers");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Noord");
        labels.add("Delfshaven");
        labels.add("Centrum");
        labels.add("Feijenoord");
        labels.add("Kralingen/Crooswijk");

        BarData data = new BarData(labels, dataset);
        barChart.setData(data); // set the data and list of lables into chart
        barChart.setDescription("A barchart showing which neighbourhoods have the most bike containers.");  // set the description
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        barChart.animateY(1500);
        barChart.setVisibleXRange(2,2);

    }

}
