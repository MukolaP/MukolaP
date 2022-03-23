package com.example.ultraproject.Calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
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

    private final CalculatorController Controller = new CalculatorController();

    @NonNull
    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.fragment_calculator, null);

        Button back_to_main = view.findViewById(R.id.back_calculator);
        navigation(back_to_main);

        TextView text = view.findViewById(R.id.result);
        ScrollView scrollView = view.findViewById(R.id.SCROLLER_ID);

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

        Button equal = view.findViewById(R.id.equal);

        Button deleteOne = view.findViewById(R.id.delete_one);
        Button deleteAll = view.findViewById(R.id.delete_all);

        text.setMovementMethod(new ScrollingMovementMethod());

        Controller.zero(zero, text);

        Controller.numPressed(one, "1", text);
        Controller.numPressed(two, "2", text);
        Controller.numPressed(three, "3", text);
        Controller.numPressed(four, "4", text);
        Controller.numPressed(five, "5", text);
        Controller.numPressed(six, "6", text);
        Controller.numPressed(seven, "7", text);
        Controller.numPressed(eight, "8", text);
        Controller.numPressed(nine, "9", text);

        Controller.actionPressed(plus, "+", text);
        Controller.actionPressed(multiplication, "*", text);
        Controller.actionPressed(division, "/", text);
        Controller.actionPressed(perCent, "%", text);

        Controller.minus(minus, text);

        Controller.equal(equal, text, scrollView);

        Controller.deleteOne(deleteOne, text);
        Controller.deleteAll(deleteAll, text);

        return view;
    }

    @SuppressLint("NonConstantResourceId")
    public void navigation(@NonNull Button button) {
        button.setOnClickListener(view -> {
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            transaction.setReorderingAllowed(true);
            transaction.replace(R.id.MainActivity, NavigationFragment.class, null);
            transaction.commit();
        });
    }
}

