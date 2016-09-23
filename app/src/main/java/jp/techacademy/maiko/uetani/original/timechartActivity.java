package jp.techacademy.maiko.uetani.original;


import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class timechartActivity extends AppCompatActivity {

    String alastdata = "10";
    String blastdata = "50";
    String clastdata = "40";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timechart);

        Firebase.setAndroidContext(this);

        Firebase firebaseRef = new Firebase("https://original-cb66c.firebaseio.com/");

        firebaseRef.child("alastdata").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                alastdata = snapshot.getValue().toString();
                Log.d("Firebase", snapshot.getValue().toString());
            }
            @Override
            public void onCancelled(FirebaseError error) {
            }
        });
        firebaseRef.child("blastdata").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                blastdata = snapshot.getValue().toString();
                Log.d("Firebase", snapshot.getValue().toString());
            }
            @Override
            public void onCancelled(FirebaseError error) {
            }
        });
        firebaseRef.child("clastdata").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                clastdata = snapshot.getValue().toString();
                Log.d("Firebase", snapshot.getValue().toString());
            }
            @Override
            public void onCancelled(FirebaseError error) {
            }
        });





        new Handler().postDelayed( delayFunc, 5000);
    }

    private void createPieChart() {
        PieChart pieChart = (PieChart) findViewById(R.id.pie_chart);

        pieChart.setDrawHoleEnabled(true); // 真ん中に穴を空けるかどうか
        pieChart.setHoleRadius(50f);       // 真ん中の穴の大きさ(%指定)
        pieChart.setHoleColorTransparent(true);
        pieChart.setTransparentCircleRadius(55f);
        pieChart.setRotationAngle(270);          // 開始位置の調整
        pieChart.setRotationEnabled(true);       // 回転可能かどうか
        pieChart.getLegend().setEnabled(true);   //
        pieChart.setDescription("PieChart 説明");
        pieChart.setData(createPieChartData());

        // 更新
        pieChart.invalidate();
        // アニメーション
        pieChart.animateXY(2000, 2000); // 表示アニメーション
    }

    // pieChartのデータ設定
    private PieData createPieChartData() {
        ArrayList<Entry> yVals = new ArrayList<>();
        ArrayList<String> xVals = new ArrayList<>();
        ArrayList<Integer> colors = new ArrayList<>();

        xVals.add("A");
        xVals.add("B");
        xVals.add("C");



        yVals.add(new Entry(Integer.parseInt(alastdata) , 0));
        yVals.add(new Entry(Integer.parseInt(blastdata) , 1));
        yVals.add(new Entry(Integer.parseInt(clastdata) , 2));

        PieDataSet dataSet = new PieDataSet(yVals, "Data");
        dataSet.setSliceSpace(5f);
        dataSet.setSelectionShift(1f);

        // 色の設定
        colors.add(ColorTemplate.COLORFUL_COLORS[0]);
        colors.add(ColorTemplate.COLORFUL_COLORS[1]);
        colors.add(ColorTemplate.COLORFUL_COLORS[2]);
        dataSet.setColors(colors);
        dataSet.setDrawValues(true);

        PieData data = new PieData(xVals, dataSet);
        data.setValueFormatter(new PercentFormatter());

        // テキストの設定
        data.setValueTextSize(12f);
        data.setValueTextColor(Color.WHITE);
        return data;
    }
    private final Runnable delayFunc= new Runnable() {
        @Override
        public void run() {
            createPieChart();
        }
    };
}







