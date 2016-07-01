package com.example.onno.testapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.List;

public class Main6Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        LineChart lineChart = (LineChart) findViewById(R.id.chart);

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");
        labels.add("July");
        labels.add("August");
        labels.add("September");
        labels.add("October");
        labels.add("November");
        labels.add("December");

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < DataLists.MKOmschrijvingList.size() ; i++) {
            if (DataLists.MKOmschrijvingList.get(i).contains("FIETS"))
                numbers.add(i);
        }

        Integer[] amounts = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < numbers.size() ; i++) {
            Integer maandNr = Integer.parseInt(DataLists.gemiddeldeMaandList.get(numbers.get(i)));
            amounts[maandNr] = amounts[maandNr] + 1;
        }

        ArrayList<Entry> entries = new ArrayList<>();
        for (int i = 1; i < amounts.length ; i++)
            entries.add(new Entry(amounts[i], i - 1));

        LineDataSet dataset = new LineDataSet(entries, "Stolen bicycles per month");
        dataset.setCircleRadius(5);
        dataset.setValueTextSize(10);
        dataset.setDrawFilled(true);
        dataset.setLineWidth(2);

        LineData data = new LineData(labels, dataset);
        lineChart.setData(data);
        lineChart.setDescription("Scroll ->");
        lineChart.setVisibleXRange(3, 3);
    }

}