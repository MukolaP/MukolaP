package com.example.ultraproject.ColorHelper;

import android.graphics.Color;

public class ColorController {
    static String complementaryColor(int red, int green, int blue){
        int x = Math.max(red, Math.max(green, blue)) + Math.min(red, Math.min(green, blue));
        return "#" + Integer.toHexString(x-red)+""+Integer.toHexString(x-green)+""+Integer.toHexString(x-blue);
    }
    static String leftAnalogousColor(float[] hsv, int red, int green, int blue){
        Color.RGBToHSV(red, green, blue, hsv);
        float anglerotation = 30f;
        if(hsv[0] - anglerotation < 0){
            hsv[0] = hsv[0] - anglerotation + 360;
        }else{
            hsv[0] -= anglerotation;
        }
        int leftColor = Color.HSVToColor(hsv);
        return "#" + Integer.toHexString(Color.red(leftColor))
                + "" + Integer.toHexString(Color.green(leftColor))
                + "" + Integer.toHexString(Color.blue(leftColor));
    }
    static String rightAnalogousColor(float[] hsv, int red, int green, int blue){
        Color.RGBToHSV(red, green, blue, hsv);
        float anglerotation = 30f;
        if(hsv[0] + anglerotation > 360){
            hsv[0] = hsv[0] + anglerotation + 360;
        }else{
            hsv[0] += anglerotation;
        }
        int rightColor = Color.HSVToColor(hsv);
        return "#" + Integer.toHexString(Color.red(rightColor))
                + "" + Integer.toHexString(Color.green(rightColor))
                + "" + Integer.toHexString(Color.blue(rightColor));
    }

    static String leftSplitComplementary(float[] hsv, int red, int green, int blue){
        int x = Math.max(red, Math.max(green, blue)) + Math.min(red, Math.min(green, blue));
        int color = Color.rgb(x - red, x - green, x - blue);
        Color.RGBToHSV(Color.red(color), Color.green(color), Color.blue(color), hsv);
        float anglerotation = 30f;
        if(hsv[0] - anglerotation < 0){
            hsv[0] = hsv[0] - anglerotation + 360;
        }else{
            hsv[0] -= anglerotation;
        }
        int leftColor = Color.HSVToColor(hsv);
        return "#"+Integer.toHexString(Color.red(leftColor))
                + "" + Integer.toHexString(Color.green(leftColor))
                + "" + Integer.toHexString(Color.blue(leftColor));
    }
    static String rightSplitComplementary(float[] hsv, int red, int green, int blue){
        int x = Math.max(red, Math.max(green, blue)) + Math.min(red, Math.min(green, blue));
        int color = Color.rgb(x - red, x - green, x - blue);
        Color.RGBToHSV(Color.red(color), Color.green(color), Color.blue(color), hsv);
        float anglerotation = 30f;

        if(hsv[0] + anglerotation >= 360){
            hsv[0] = (hsv[0]+anglerotation) - 360;
        }else{
            hsv[0] += anglerotation;
        }
        int rightColor = Color.HSVToColor(hsv);
        return "#"+Integer.toHexString(Color.red(rightColor))
                + "" + Integer.toHexString(Color.green(rightColor))
                + "" + Integer.toHexString(Color.blue(rightColor));
    }


}
