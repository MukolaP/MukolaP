package com.example.ultraproject.ColorHelper;

import android.graphics.Color;

public class ColorController extends ColorValue{

    static String leftRotated(float angleRotation){
        Color.RGBToHSV(red(), green(), blue(), hsv);
        if (hsv[0] - angleRotation <= 0){
            hsv[0] = (hsv[0]-angleRotation)+360;
        }else{
            hsv[0] -= angleRotation;
        }
        int leftColor = Color.HSVToColor(hsv);
        return "#"+Integer.toHexString(Color.red(leftColor))
                + "" + Integer.toHexString(Color.green(leftColor))
                + "" + Integer.toHexString(Color.blue(leftColor));
    }

    static String rightRotated(float angleRotation){
        Color.RGBToHSV(red(), green(), blue(), hsv);
        if (hsv[0] + angleRotation >= 360f){
            hsv[0] = (hsv[0]+angleRotation)-360;
        }else{
            hsv[0] += angleRotation;
        }
        int rightColor = Color.HSVToColor(hsv);
        return "#"+Integer.toHexString(Color.red(rightColor))
                + "" + Integer.toHexString(Color.green(rightColor))
                + "" + Integer.toHexString(Color.blue(rightColor));
    }
}
