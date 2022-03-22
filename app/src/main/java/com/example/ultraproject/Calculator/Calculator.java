package com.example.ultraproject.Calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.ultraproject.NavigationFragment;
import com.example.ultraproject.R;

public final class Calculator extends Fragment {

    private boolean equal = false;

    private final CalculatorController calculatorController = new CalculatorController();
    private ScrollView scrollView;
    private TextView text;

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.fragment_calculator, null);

        Button back_to_main = view.findViewById(R.id.back_calculator);
        navigation(back_to_main);

        text = view.findViewById(R.id.result);
        scrollView = view.findViewById(R.id.SCROLLER_ID);

        Button zero = view.findViewById(R.id.number_zero);
        Button one = view.findViewById(R.id.number_one);
        Button two = view.findViewById(R.id.number_two);
        Button three = view.findViewById(R.id.number_three);
        Button four = view.findViewById(R.id.number_four);
        Button five = view.findViewById(R.id.number_five);
        Button six = view.findViewById(R.id.number_six);
        Button seven = view.findViewById(R.id.number_seven);
        Button eight = view.findViewById(R.id.number_eight);
        Button nine = view.findViewById(R.id.number_nine);

        Button plus = view.findViewById(R.id.action_plus);
        Button minus = view.findViewById(R.id.action_minus);
        Button multiplication = view.findViewById(R.id.action_multiplication);
        Button division = view.findViewById(R.id.action_division);
        Button perCent = view.findViewById(R.id.action_per_cent);

        Button ButtonEqual = view.findViewById(R.id.equal);

        Button deleteOne = view.findViewById(R.id.delete_one);
        Button deleteAll = view.findViewById(R.id.delete_all);

        text.setMovementMethod(new ScrollingMovementMethod());

        zero(zero);

        ButtonNumPressed(one, "1");
        ButtonNumPressed(two, "2");
        ButtonNumPressed(three, "3");
        ButtonNumPressed(four, "4");
        ButtonNumPressed(five, "5");
        ButtonNumPressed(six, "6");
        ButtonNumPressed(seven, "7");
        ButtonNumPressed(eight, "8");
        ButtonNumPressed(nine, "9");

        ButtonActionPressed(plus, "+");
        ButtonActionPressed(multiplication, "*");

        minus(minus);

        ButtonActionPressed(division, "/");
        ButtonActionPressed(perCent, "%");

        equal(ButtonEqual);

        deleteOne(deleteOne);
        deleteAll(deleteAll);

        return view;
    }

    @SuppressLint("NonConstantResourceId")
    public void navigation(Button button) {
        button.setOnClickListener(view -> {
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            if (view.getId() == R.id.back_calculator) {
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.MainActivity, NavigationFragment.class, null);
                transaction.commit();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void ButtonNumPressed(Button button, String number) {
        button.setOnClickListener(view -> {
            text.setText(text.getText() + number);
            calculatorController.setString(calculatorController.getString() + number);
        });
    }

    @SuppressLint("SetTextI18n")
    public void ButtonActionPressed(Button button, String action) {
        button.setOnClickListener(view -> {
            if (calculatorController.getString().length() != 0 & calculatorController.StringEqualAction()) {
                text.setText(text.getText() + action);
                calculatorController.setString(calculatorController.getString() + action);
                String new_action = action.replace("+", "\\+");
                new_action = new_action.replace("*", "\\*");
                calculatorController.setAction(new_action);
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void minus(Button button){
        button.setOnClickListener(view18 -> {
            if (calculatorController.StringEqualAction()) {
                text.setText(text.getText() + "-");
                calculatorController.setString(calculatorController.getString() + "-");
                calculatorController.setAction("-");
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void equal(Button button){
        button.setOnClickListener(view14 -> {
            if (!calculatorController.getString().equals("") & !calculatorController.getAction().equals("")) {
                if (calculatorController.StringEqualAction()) {
                    text.setText(text.getText() + calculatorController.solution() + "\n");
                    equal = true;
                    scrollView.fullScroll(View.FOCUS_DOWN);
                }
            }
        });
    }

    public void deleteOne(Button button){
        button.setOnClickListener(view15 -> {
            if (!equal & calculatorController.getString().length() != 0) {
                text.setText(calculatorController.getDeleteOneString());
            } else if (equal) {
                text.setText("");
                equal = false;
            }
        });
    }

    public void deleteAll(Button button){
        button.setOnClickListener(view16 -> {
            text.setText("");
            calculatorController.setString("");
        });
    }

    @SuppressLint("SetTextI18n")
    public void zero(Button button){
        button.setOnClickListener(view1 -> {
            if (!text.getText().toString().equals("") & calculatorController.ZeroException()) {
                text.setText(text.getText() + "0");
                calculatorController.setString(calculatorController.getString() + "0");
            }
        });
    }
}
