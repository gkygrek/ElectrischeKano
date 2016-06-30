package com.example.onno.testapp;

import android.graphics.Color;
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
import com.github.mikephil.charting.utils.ColorTemplate;
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
        String deelGem = "hoogvliet";

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
            if (DataLists.MKOmschrijvingList.get(i).toLowerCase().contains("fiets"))
                numbers.add(i);
        }

        Integer[] amounts = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < numbers.size() ; i++) {
            Integer maandNr = Integer.parseInt(DataLists.gemiddeldeMaandList.get(numbers.get(i)));
            if (getDeelGem(DataLists.werkgebiedList.get(i)).toLowerCase().contains(deelGem.toLowerCase()))
                amounts[maandNr] = amounts[maandNr] + 1;
        }

        ArrayList<BarEntry> group1 = new ArrayList<>();
        for (int i = 1; i < amounts.length ; i++)
            group1.add(new BarEntry(amounts[i], i - 1));

        Integer[] amounts2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < DataLists.datumList.size() ; i++) {
            if (DataLists.deelgemList.get(i).toLowerCase().contains(deelGem.toLowerCase())) {
                String datum = DataLists.datumList.get(i);
                datum = datum.substring(datum.indexOf("-") + 1);
                datum = datum.substring(0, datum.indexOf("-"));
                Integer maandNr = Integer.parseInt(datum);
                amounts2[maandNr] = amounts2[maandNr] + 1;
            }
        }

        for (int i = 0; i < DataLists.deelgemList.size(); i++) {
            System.out.println(DataLists.deelgemList.get(i));
        }

        for (int i = 1; i < amounts2.length; i++) {
            System.out.println(amounts2[i]);
        }

        ArrayList<BarEntry> group2 = new ArrayList<>();
        for (int i = 1; i < amounts2.length ; i++)
            group2.add(new BarEntry(amounts2[i], i - 1));

        BarDataSet barDataSet1 = new BarDataSet(group1, "Hoeveelheid fietsiefstal");
        BarDataSet barDataSet2 = new BarDataSet(group2, "Hoeveelheid fietstrommels");
        int[] redColor =  {ColorTemplate.rgb("#ff0000")};
        barDataSet2.setColors(redColor);

        BarData data = new BarData(labels, barDataSet1);
        data.addDataSet(barDataSet2);
        barChart.setData(data);
        barChart.setVisibleXRange(0, 10);

    }

    private String getDeelGem(String wijk) {
        wijk = wijk.toLowerCase();
        if (wijk.contains("stadsdriehoek") || wijk.contains("cool") || wijk.contains("cs-kwartier") || wijk.contains("dijkzigt") || wijk.contains("nieuwe werk") || wijk.contains("scheepvaartkwartier"))
            return "centrum";
        if (wijk.contains("delfshaven") || wijk.contains("bospolder") || wijk.contains("tussendijken") || wijk.contains("spangen") || wijk.contains("nieuwe westen") || wijk.contains("middelland") || wijk.contains("oud-mathenesse") || wijk.contains("witte dorp") || wijk.contains("schiemond"))
            return "delfshaven";
        if (wijk.contains("overschie") || wijk.contains("kleinpolder") || wijk.contains("noord-kethel") || wijk.contains("schieveen") || wijk.contains("zestienhoven") || wijk.contains("landzicht"))
            return "overschie";
        if (wijk.contains("agniesebuurt") || wijk.contains("provenierswijk") || wijk.contains("bergpolder") || wijk.contains("blijdorp") || wijk.contains("liskwartier") || wijk.contains("oude noorden") || wijk.contains("blijdorpse polder"))
            return "noord";
        if (wijk.contains("schiebroek") || wijk.contains("hillegersberg-noord") || wijk.contains("110-morgen") || wijk.contains("hillegersberg-zuid ") || wijk.contains("terbregge") || wijk.contains("molenlaankwartier") || wijk.contains("kleiwegkwartier"))
            return "hillegersberg";
        if (wijk.contains("rubroek") || wijk.contains("crooswijk") || wijk.contains("kralingen") || wijk.contains("kralingse") || wijk.contains("de esch") || wijk.contains("struisenburg"))
            return "kralingen";
        if (wijk.contains("feijenoord") || wijk.contains("noordereiland") || wijk.contains("vreewijk") || wijk.contains("bloemhof") || wijk.contains("hillesluis") || wijk.contains("katendrecht") || wijk.contains("afrikaanderwijk") || wijk.contains("kop van zuid"))
            return "feijenoord";
        if (wijk.contains("ijsselmonde") || wijk.contains("lombardijen") || wijk.contains("groenenhagen") || wijk.contains("hordijkerveld") || wijk.contains("kreekhuizen") || wijk.contains("reyeroord") || wijk.contains("sportdorp") || wijk.contains("veranda") || wijk.contains("zomerland") || wijk.contains("beverwaard") || wijk.contains("pernis") || wijk.contains("rozenburg") || wijk.contains("noordzeeweg"))
            return "ijsselmonde";
        if (wijk.contains("tarwewijk") || wijk.contains("carnisse") || wijk.contains("zuidwijk") || wijk.contains("charlois") || wijk.contains("wielewaal") || wijk.contains("zuidplein") || wijk.contains("pendrecht") || wijk.contains("zuiderpark") || wijk.contains("heijplaat"))
            return "charlois";
        if (wijk.contains("oudeland") || wijk.contains("hoogvliet") || wijk.contains("oudeland") || wijk.contains("nieuw engeland") || wijk.contains("tussenwater") || wijk.contains("westpunt") || wijk.contains("middengebied") || wijk.contains("meeuwenplaat") || wijk.contains("zalmplaat") || wijk.contains("boomgaardshoek") || wijk.contains("hoek van holland"))
            return "hoogvliet";
        return "null";
    }

}
