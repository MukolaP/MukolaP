package com.example.ultraproject;

public class CalculatorModel {

    private String string = "", action = "";
    private int value, value1;

    public String solution (){
        switch (action) {
            case ("\\+"):
                resultToEqual(action, string);
                return " = " + (value + value1);
            case ("-"):
                if (!string.substring(0,1).equals(action)){
                    resultToEqual(action, string);
                    return " = " + (value - value1);
                } else {
                    string = string.substring(1);
                    String[] paradigm = string.split("-", 2);

                    string = "";
                    action = "";

                    return " = " + (- Integer.parseInt(paradigm[0]) - Integer.parseInt(paradigm[1]));
            }
            case ("\\*"):
                resultToEqual(action, string);
                return " = " + value * value1;
            case ("/"):
                resultToEqual(action, string);
                return " = " + value / value1;
            case ("%"):
                resultToEqual(action, string);
                return " = " + value % value1;
        }
        return "";
    }

    public void resultToEqual (String action, String string){
        String[] paradigm = string.split(action, 2);

        value = Integer.parseInt(paradigm[0]);
        value1 = Integer.parseInt(paradigm[1]);
        this.string = "";
        this.action = "";
    }

    public String getString() {
        return string;
    }

    public void getNulString() {
        string = "";
    }

    public String getDeleteOneString(){
        return string = getString().substring(0, getString().length() - 1); }

    public void paradigmEqualTo(String string){
        this.string  += string;
    }

    public String getAction() {
        return action;
    }

    public void actionEqualTo(String action){ this.action  = action;}

    public boolean StringEqualAction() {
        if (getString().length() != 0) {
            String action = getAction().replace("\\+", "+");
            action = action.replace("\\*", "*");
            return !getString().substring(getString().length() - 1).equals(action);
        }
        return true;
    }
    public boolean ZeroException(){
        return !getString().endsWith("/");
    }
}
