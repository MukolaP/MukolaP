package com.example.ultraproject.ColorHelper;

import android.graphics.Color;
import android.widget.FrameLayout;

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

    static String cmyk(){
        double percentageR = red() / 255.0 * 100;
        double percentageG = green() / 255.0 * 100;
        double percentageB = blue() / 255.0 * 100;
        int k = (int) (100 - Math.max(Math.max(percentageR, percentageG), percentageB));
        if (k == 100) {
            return "0, 0, 0, 100";
        }
        int c = (int) ((100 - percentageR - k) / (100 - k) * 100);
        int m = (int) ((100 - percentageG - k) / (100 - k) * 100);
        int y = (int) ((100 - percentageB - k) / (100 - k) * 100);
        return c + ", " + m + ", " + y + ", " + k;
    }

    static void changeToMain(FrameLayout frameLayout){
        frameLayout.setBackgroundColor(Color.parseColor(ColorValue.getColor()));
    }
    static void rotateRight(FrameLayout frameLayout, float degree){
        frameLayout.setBackgroundColor(Color.parseColor(ColorController.rightRotated(degree)));
    }
    static void rotateLeft(FrameLayout frameLayout, float degree){
        frameLayout.setBackgroundColor(Color.parseColor(ColorController.leftRotated(degree)));
    }

}
