package com.example.ultraproject.Calculator;

public class CalculatorModel {

    protected String string = "", action = "";
    protected float value, value1;
    protected boolean equal = false;
    protected boolean minus = false;

    public final String getString() { return string; }

    public final void setString(String string) { this.string = string; }

    public final String getAction() {
        return action;
    }
}
