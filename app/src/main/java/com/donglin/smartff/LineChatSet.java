package com.donglin.smartff;

import android.graphics.Color;

import com.donglin.smartff.utils.MColorArray;
import com.donglin.smartff.mvp.model.entity.AlarmInfo4OneDay;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.LineChartView;

/**
 * Created by Administrator on 2018/1/10 0010.
 */

public class LineChatSet {

    private final List<AlarmInfo4OneDay> lists;
    private LineChartView chart;
    private int numberOfLines;
    private int maxNumberOfLines;
    private int numberOfPoints;

    private ArrayList<AxisValue> axisValuesX = new ArrayList<AxisValue>();//定义X轴刻度值的数据集合

    float[][] randomNumbersTab;
    private LineChartData data;
    private boolean hasAxes = true;
    private boolean hasAxesNames = true;
    private boolean hasLines = true;
    private boolean hasPoints = false;
    private ValueShape shape = ValueShape.CIRCLE;
    private boolean isFilled = true;
    private boolean hasLabels = false;
    private boolean isCubic = false;
    private boolean hasLabelForSelected = false;
    private boolean pointsHaveDifferentColor;
    private boolean hasGradientToTransparent = false;

    public LineChatSet(LineChartView chart, List<AlarmInfo4OneDay> lists) {
        this.chart = chart;
        this.lists = lists;
        numberOfLines = lists.size();
        maxNumberOfLines = lists.size();
        numberOfPoints = lists.get(0).getTimes().size();
        randomNumbersTab = new float[maxNumberOfLines][numberOfPoints];
        generateValues();
        generateData();

    }

    private void generateData() {
        List<Line> lines = new ArrayList<Line>();
        for (int i = 0; i < numberOfLines; ++i) {
            List<PointValue> values = new ArrayList<PointValue>();
            for (int j = 0; j < numberOfPoints; ++j) {
                //values.add(new PointValue(j, randomNumbersTab[i][j]));
                values.add(new PointValue(j,lists.get(i).getTimes().get(j).getSize()));
            }

            Line line = new Line(values);
            String colorRandom = MColorArray.getRandomColor();
            //MLog.e(colorRandom);
            line.setColor(Color.parseColor(lists.get(i).getOrgColor()));
            line.setShape(shape);
            line.setCubic(isCubic);
            line.setFilled(isFilled);
            line.setHasLabels(hasLabels);
            line.setHasLabelsOnlyForSelected(hasLabelForSelected);
            line.setHasLines(hasLines);
            line.setHasPoints(hasPoints);
            // line.setHasGradientToTransparent(hasGradientToTransparent);
            if (pointsHaveDifferentColor) {
                line.setPointColor(ChartUtils.COLORS[(i + 1) % ChartUtils.COLORS.length]);
            }
            lines.add(line);
        }

        data = new LineChartData(lines);

        if (hasAxes) {
            Axis axisX = new Axis();
            Axis axisY = new Axis().setHasLines(true);
            axisX.setLineColor(Color.RED);// 设置X轴轴线颜色
            axisY.setLineColor(R.color.colorPrimaryDark);// 设置Y轴轴线颜色
            axisX.setTextColor(R.color.colorPrimaryDark);// 设置X轴文字颜色
            axisY.setTextColor(R.color.colorPrimaryDark);// 设置Y轴文字颜色
            for (int i = 0; i < numberOfPoints; i++) {
                axisValuesX.add(new AxisValue(i).setLabel(i + "H"));
            }
            axisX.setValues(axisValuesX);//为X轴显示的刻度值设置数据集合
            if (hasAxesNames) {
                axisX.setName("今日24时报警记录");
                //axisY.setName("个数");
            }
            data.setAxisXBottom(axisX);
            data.setAxisYLeft(axisY);

        } else {
            data.setAxisXBottom(null);
            data.setAxisYLeft(null);
        }

        data.setBaseValue(Float.NEGATIVE_INFINITY);
        chart.setLineChartData(data);

    }

    private void generateValues() {
        for (int i = 0; i < maxNumberOfLines; ++i) {
            for (int j = 0; j < numberOfPoints; ++j) {
                randomNumbersTab[i][j] = (float) Math.random() * 100f;
            }
        }
    }


}
