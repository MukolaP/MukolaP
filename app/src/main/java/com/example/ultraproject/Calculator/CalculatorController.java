package com.example.ultraproject.Calculator;

public final class CalculatorController extends CalculatorModel{

    public final String solution (){
        switch (action) {
            case ("\\+"):
                resultToEqual();
                return " = " + (value + value1);
            case ("\\*"):
                resultToEqual();
                return " = " + value * value1;
            case ("/"):
                resultToEqual();
                return " = " + value / value1;
            case ("%"):
                resultToEqual();
                return " = " + value % value1;
            case ("-"):
                if (!string.substring(0,1).equals(action)){
                    resultToEqual();
                    return " = " + (value - value1);
                } else {
                    string = string.substring(1);
                    String[] paradigm = string.split("-", 2);

                    string = "";
                    action = "";

                    return " = " + (- Integer.parseInt(paradigm[0]) - Integer.parseInt(paradigm[1]));
                }
        }
        return "";
    }

    public final void resultToEqual () {
        String[] paradigm = string.split(action, 2);

        value = Integer.parseInt(paradigm[0]);
        value1 = Integer.parseInt(paradigm[1]);
        string = "";
        action = "";
    }

    public final String getDeleteOneString(){
        return string = string.substring(0, string.length() - 1); }

    public final boolean StringEqualAction() {
        if (string.length() != 0) {
            String action = getAction().replace("\\+", "+");
            action = action.replace("\\*", "*");
            return !string.substring(string.length() - 1).equals(action);
        }
        return true;
    }

    public final boolean ZeroException(){ return !string.endsWith("/"); }
}
