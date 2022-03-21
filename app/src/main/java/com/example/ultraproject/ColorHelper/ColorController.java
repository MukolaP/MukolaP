package com.example.ultraproject.ColorHelper;

public class ColorController {
    static String ComplementaryColor(int red, int green, int blue){
        int x = Math.max(red, Math.max(green, blue)) + Math.min(red, Math.min(green, blue));
        return "#" + Integer.toHexString(x-red)+""+Integer.toHexString(x-green)+""+Integer.toHexString(x-blue);
    }
}
