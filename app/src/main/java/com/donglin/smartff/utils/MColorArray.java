package com.donglin.smartff.utils;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by Administrator on 2018/1/11 0011.
 */

public class MColorArray {
    public static final int COLOR_BLUE = Color.parseColor("#33B5E5");
    public static final int COLOR_VIOLET = Color.parseColor("#AA66CC");
    public static final int COLOR_GREEN = Color.parseColor("#99CC00");
    public static final int COLOR_ORANGE = Color.parseColor("#FFBB33");
    public static final int COLOR_RED = Color.parseColor("#FF4444");

    private static final int[] COLORS;

    static {
        COLORS = new int[]{COLOR_BLUE, COLOR_VIOLET, COLOR_GREEN, COLOR_ORANGE, COLOR_RED};
    }
  /*  Color color = new Color(
            (new Double(Math.random() * -128)).intValue() + 128,
            (new Double(Math.random() * 128)).intValue() + 128,
            (new Double(Math.random() * 128)).intValue() + 128);*/

    public static String getRandomColor() {
        StringBuffer sb = new StringBuffer();
        sb.append("#");
        sb.append(getRGB());
        sb.append(getRGB());
        sb.append(getRGB());
        return sb.toString();
    }

    public static String getRGB() {
        int colorInt = new Random().nextInt(239) + 16;
        String colorString = Integer.toHexString(colorInt);
        return colorString;
    }
}
