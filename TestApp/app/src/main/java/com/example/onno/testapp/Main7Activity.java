package com.example.onno.testapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.List;

public class Main7Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BarChart barChart = (BarChart) findViewById(R.id.chart);
        String buurt = "COOL";

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
            if (DataLists.buurtList.get(i).contains(buurt))
                amounts[maandNr] = amounts[maandNr] + 1;
        }

        ArrayList<BarEntry> entries = new ArrayList<>();
        for (int i = 1; i < amounts.length ; i++)
            entries.add(new BarEntry(amounts[i], i - 1));

        BarDataSet dataset = new BarDataSet(entries, "Data");
        BarData data = new BarData(labels, dataset);
        barChart.setData(data);

    }

}
