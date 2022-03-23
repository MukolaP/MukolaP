package com.example.ultraproject.Calculator;

public class CalculatorModel {

    protected String string = "", action = "";
    protected int value, value1;
    protected boolean equal = false;

    public final String getString() { return string; }

    public final void setString(String string) { this.string = string; }

    public final String getAction() {
        return action;
    }

    public final void setAction(String action) {
        this.action = action;
    }
}
