package com.example.onno.testapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main6Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
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

        int x = 0;
        String buurt = "NOORD";
        int y = 0;
        int d = 1;
        boolean next = false;
        List<Integer> yAs = new ArrayList<>();
        List<Integer> xAs = new ArrayList<>();

                        while (d < 13)
                        {
                            for (int g = 1; g < DataLists.gemiddeldeMaandList.size(); g++) {
                                if (DataLists.buurtList.get(g).contains(buurt)) {
                                    System.out.println(2);
                                    if (DataLists.gemiddeldeJaarList.get(g).contains("2011")) {
                                        if (Integer.parseInt(DataLists.gemiddeldeMaandList.get(g)) == d) {
                                            System.out.println(4);
                                            x = x + 1;
                                        }

                                    }


                                }
                            }
                            y = d;
                            yAs.add(y);
                            xAs.add(x);
                            d = d+1;
                            x = 0;


                        }
        d = 0;
        while (d < 13)
        {
            for (int g = 1; g < DataLists.gemiddeldeMaandList.size(); g++) {
                if (DataLists.buurtList.get(g).contains(buurt)) {
                    System.out.println(2);
                    if (DataLists.gemiddeldeJaarList.get(g).contains("2012")) {
                        if (Integer.parseInt(DataLists.gemiddeldeMaandList.get(g)) == d) {
                            System.out.println(4);
                            x = x + 1;
                        }

                    }


                }
            }
            y = d + 12;
            yAs.add(y);
            xAs.add(x);
            d = d+1;
            x = 0;


        }
        d = 0;
        while (d < 13)
        {
            for (int g = 1; g < DataLists.gemiddeldeMaandList.size(); g++) {
                if (DataLists.buurtList.get(g).contains(buurt)) {
                    System.out.println(2);
                    if (DataLists.gemiddeldeJaarList.get(g).contains("2013")) {
                        if (Integer.parseInt(DataLists.gemiddeldeMaandList.get(g)) == d) {
                            System.out.println(4);
                            x = x + 1;
                        }

                    }


                }
            }
            y = d + 24;
            yAs.add(y);
            xAs.add(x);
            d = d+1;
            x = 0;


        }



                DataPoint[] data = new DataPoint[yAs.size()];
                for (int k = 0; k < yAs.size(); k++) {
                    data[k] = new DataPoint(yAs.get(k), xAs.get(k));
                }

                GraphView graph = (GraphView) findViewById(R.id.graph);
                LineGraphSeries<DataPoint> series = new LineGraphSeries<>(data


                );
                graph.addSeries(series);

            }

        }
