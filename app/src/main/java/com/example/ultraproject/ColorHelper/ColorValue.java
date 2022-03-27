package com.example.ultraproject.ColorHelper;

import android.graphics.Color;

public class ColorValue {
    private static String color = "#123123";
    public static int red(){return Integer.parseInt(color.substring(1, 3), 16);}
    public static int green(){return Integer.parseInt(color.substring(3, 5), 16);}
    public static int blue(){return Integer.parseInt(color.substring(5, 7), 16);}

    static String rgb(){return red()+", "+green()+", "+blue();}
    static String hsv(){
        float[] hsv1 = new float[3];
        Color.RGBToHSV(red(), green(), blue(), hsv1);
        return hsv1[0]+", "+hsv1[1]+", "+hsv1[2];
    }
    static String bin(){return Integer.toBinaryString(red())
            +", "+Integer.toBinaryString(blue())
            +", "+Integer.toBinaryString(green());}



    public static float[] hsv = new float[3];


    public static void setColor(String color) {
        ColorValue.color = color;
    }

    public static String getColor() {
        return color;
    }


}
