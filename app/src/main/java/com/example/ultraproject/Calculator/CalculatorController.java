package com.example.ultraproject.Calculator;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public final class CalculatorController extends CalculatorModel {

    @SuppressLint("DefaultLocale")
    @NonNull
    public final String solution() {
        string = string.replace(",", ".");
        minusNumber();
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
                resultToEqual();
                return " = " + (value - value1);
            case ("--"):
                string = string.substring(1);
                String[] paradigm = string.split("-", 2);
                zeroing();
                return " = " + (-Float.parseFloat(paradigm[0]) - Float.parseFloat(paradigm[1]));
            case ("sin"):
                String paradigmSin = string.substring(4);
                zeroing();
                return ") = " + String.format("%.2f", Math.sin(Float.parseFloat(paradigmSin)));
            case ("cos"):
                String paradigmCos = string.substring(4);
                zeroing();
                return ") = " + String.format("%.2f", Math.cos(Float.parseFloat(paradigmCos)));
        }
        return "";
    }

    public final void resultToEqual() {
        String[] paradigm = string.split(action, 2);

        value = Float.parseFloat(paradigm[0]);
        value1 = Float.parseFloat(paradigm[1]);
        zeroing();
    }

    public final String getDeleteOneString() {
        return string = string.substring(0, string.length() - 1);
    }

    public final boolean stringEqualAction() {
        if (stringNull()) {
            String action = getAction().replace("\\+", "+");
            action = action.replace("\\*", "*");
            return !string.substring(string.length() - 1).equals(action);
        }
        return true;
    }

    public final boolean zeroException() {
        return !string.endsWith("/");
    }

    public final boolean stringNull() {
        return string.length() != 0;
    }

    public void EditView(@NonNull TextView text) {
        text.setText(string);
    }

    public void zeroing(){
        string = "";
        action = "";
    }

    public void minusNumber(){
        if (string.substring(0, 1).equals(action)) {
            action = action.replace("-", "--");
        }
    }

    @SuppressLint("SetTextI18n")
    public void numPressed(@NonNull Button button, String number, TextView text) {
        button.setOnClickListener(view -> {
            string += number;
            EditView(text);
        });
    }

    @SuppressLint("SetTextI18n")
    public void actionPressed(@NonNull Button button, String action, TextView text) {
        button.setOnClickListener(view -> {
            if (stringNull() & stringEqualAction()) {
                string += action;
                EditView(text);

                String new_action = action.replace("+", "\\+");
                new_action = new_action.replace("*", "\\*");
                this.action = new_action;
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void minus(@NonNull Button button, TextView text) {
        button.setOnClickListener(view18 -> {
            if (stringEqualAction()) {
                string += "-";
                action = "-";
                EditView(text);
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void sin(@NonNull Button button, TextView text, String string, String action){
        button.setOnClickListener(view1 -> {
            this.string = string;
            this.action = action;
            EditView(text);
        });
    }

    @SuppressLint("SetTextI18n")
    public void equal(@NonNull Button button, TextView text, TextView history, ScrollView scrollView) {
        button.setOnClickListener(view14 -> {
            if (!string.equals("") & !action.equals("") & stringEqualAction()) {
                text.setText(text.getText() + solution());

                addTextView(text, history);
                scrollView.fullScroll(View.FOCUS_DOWN);
                equal = true;
            }
        });
    }

    public void coma(Button button, TextView text, String string){
        button.setOnClickListener(view -> {
            if (stringNull()) {
                this.string += string;
                EditView(text);
            }
        });
    }

    public void deleteOne(@NonNull ImageButton button, TextView text) {
        button.setOnClickListener(view15 -> {
            if (!equal & stringNull()) {
                text.setText(getDeleteOneString());
            } else if (equal & action.length() == 0) {
                text.setText("");
                equal = false;
            }
        });
    }

    public void deleteAll(@NonNull Button button, TextView text) {
        button.setOnClickListener(view16 -> {
            string = "";
            EditView(text);
        });
    }

    @SuppressLint("SetTextI18n")
    public void zero(@NonNull Button button, TextView text) {
        button.setOnClickListener(view1 -> {
            if (stringNull() & zeroException()) {
                string += "0";
                EditView(text);
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void addTextView(@NonNull TextView text, @NonNull TextView history) {
        history.setText(history.getText() + text.getText().toString() + "\n");
    }
}
