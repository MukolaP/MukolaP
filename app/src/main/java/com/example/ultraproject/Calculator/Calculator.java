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

    private final CalculatorModel calculatorModel = new CalculatorModel();
    private ScrollView mScrollView;
    private TextView text;

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.fragment_calculator, null);

        Button back_to_main = view.findViewById(R.id.back_calculator);
        navigation(back_to_main);

        text = view.findViewById(R.id.result);
        mScrollView = view.findViewById(R.id.SCROLLER_ID);

        Button ButtonNumber_zero = view.findViewById(R.id.number_zero);
        Button ButtonNumber_one = view.findViewById(R.id.number_one);
        Button ButtonNumber_two = view.findViewById(R.id.number_two);
        Button ButtonNumber_three = view.findViewById(R.id.number_three);
        Button ButtonNumber_four = view.findViewById(R.id.number_four);
        Button ButtonNumber_five = view.findViewById(R.id.number_five);
        Button ButtonNumber_six = view.findViewById(R.id.number_six);
        Button ButtonNumber_seven = view.findViewById(R.id.number_seven);
        Button ButtonNumber_eight = view.findViewById(R.id.number_eight);
        Button ButtonNumber_nine = view.findViewById(R.id.number_nine);

        Button ButtonAction_plus = view.findViewById(R.id.action_plus);
        Button ButtonAction_minus = view.findViewById(R.id.action_minus);
        Button ButtonAction_multiplication = view.findViewById(R.id.action_multiplication);
        Button ButtonAction_division = view.findViewById(R.id.action_division);
        Button ButtonAction_PerCent = view.findViewById(R.id.action_per_cent);

        Button ButtonEqual = view.findViewById(R.id.equal);

        Button ButtonDeleteOne = view.findViewById(R.id.delete_one);
        Button ButtonDeleteAll = view.findViewById(R.id.delete_all);

        text.setMovementMethod(new ScrollingMovementMethod());

        ButtonNumber_zero.setOnClickListener(
                view1 -> {
                    if (!text.getText().toString().equals("") & calculatorModel.ZeroException()) {
                        text.setText(text.getText() + "0");
                        calculatorModel.setString(calculatorModel.getString() + "0");
                    }
                });

        ButtonNumPressed(ButtonNumber_one, "1");
        ButtonNumPressed(ButtonNumber_two, "2");
        ButtonNumPressed(ButtonNumber_three, "3");
        ButtonNumPressed(ButtonNumber_four, "4");
        ButtonNumPressed(ButtonNumber_five, "5");
        ButtonNumPressed(ButtonNumber_six, "6");
        ButtonNumPressed(ButtonNumber_seven, "7");
        ButtonNumPressed(ButtonNumber_eight, "8");
        ButtonNumPressed(ButtonNumber_nine, "9");

        ButtonActionPressed(ButtonAction_plus, "+");
        ButtonActionPressed(ButtonAction_multiplication, "*");

        ButtonAction_minus.setOnClickListener(
                view18 -> {
                    if (calculatorModel.StringEqualAction()){
                        text.setText(text.getText() + "-");
                        calculatorModel.setString(calculatorModel.getString() + "-");
                        calculatorModel.setAction("-");
                    }
                });

        ButtonActionPressed(ButtonAction_division, "/");
        ButtonActionPressed(ButtonAction_PerCent, "%");

        ButtonEqual.setOnClickListener(
                view14 -> {
                    if (!calculatorModel.getString().equals("") & !calculatorModel.getAction().equals("")) {
                        if (calculatorModel.StringEqualAction()) {
                            text.setText(text.getText() + calculatorModel.solution() + "\n");
                            equal = true;
                            mScrollView.fullScroll(View.FOCUS_DOWN);
                        }
                    }
                });

        ButtonDeleteOne.setOnClickListener(
                view15 -> {
                    if (!equal & calculatorModel.getString().length() != 0) {
                        text.setText(calculatorModel.getDeleteOneString());
                    } else if (equal) {
                        text.setText("");
                        equal = false;
                    }
                });

        ButtonDeleteAll.setOnClickListener(
                view16 -> {
                    text.setText("");
                    calculatorModel.setString("");
                });

        return view;
    }

    @SuppressLint("SetTextI18n")
    public void ButtonNumPressed(Button button, String number) {
        button.setOnClickListener(
                view -> {
                    text.setText(text.getText() + number);
                    calculatorModel.setString(calculatorModel.getString() + number);
                });
    }

    @SuppressLint("SetTextI18n")
    public void ButtonActionPressed(Button button, String action) {
        button.setOnClickListener(
                view -> {
                    if (calculatorModel.getString().length() != 0 & calculatorModel.StringEqualAction()) {
                        text.setText(text.getText() + action);
                        calculatorModel.setString(calculatorModel.getString() + action);
                        String new_action = action.replace("+", "\\+");
                        new_action = new_action.replace("*", "\\*");
                        calculatorModel.setAction(new_action);
                    }
                });
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
}
