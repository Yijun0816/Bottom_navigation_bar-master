package com.example.bottomnavigation;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class homeActivity extends AppCompatActivity {

    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        pieChart = (PieChart) findViewById(R.id.piechart);

        pieChart.setRotationEnabled(false);     // 可以手动旋转
        pieChart.setUsePercentValues(true);     //显示成百分比
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5,10,5,5);

        pieChart.setDragDecelerationFrictionCoef(0.99f);

        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(61f);
        pieChart.setEntryLabelTextSize(15f);

        //大小
        ArrayList<PieEntry> sizes=new ArrayList<PieEntry>();
        sizes.add(new PieEntry(90,"水量"));
        sizes.add(new PieEntry(10,"空值"));

        //颜色
        ArrayList<Integer> colors=new ArrayList<Integer>();
        colors.add(Color.parseColor("#87CEEB"));
        colors.add(Color.parseColor("#808A87"));

        pieChart.animateY(1000, Easing.EaseInOutCubic);     //動畫

        PieDataSet pieDataSet=new PieDataSet(sizes,"");
        pieDataSet.setColors(colors);
        pieDataSet.setSliceSpace(3f);
        pieDataSet.setSelectionShift(5f);

        PieData data = new PieData((pieDataSet));
        data.setValueTextSize(15f);
        data.setValueTextColor(Color.BLACK);
        pieChart.setData(data);
        pieChart.invalidate();
    }
}