package com.example.ultraproject.Calculator;

import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
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
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;


import com.example.ultraproject.NavigationFragment;
import com.example.ultraproject.R;

public final class Calculator extends Fragment {

    private SharedPreferences sPref;
    private final String SAVED_TEXT = "saved_text";
    private TextView history;

    private final CalculatorController Controller = new CalculatorController();

    @NonNull
    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.fragment_calculator, null);

        Button back_to_main = view.findViewById(R.id.back_calculator);
        navigation(back_to_main);

        TextView paradigm = view.findViewById(R.id.paradigm);
        history = view.findViewById(R.id.history);

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
        Button sin = view.findViewById(R.id.action_sin);
        Button cos = view.findViewById(R.id.action_cos);

        Button equal = view.findViewById(R.id.equal);
        Button coma = view.findViewById(R.id.coma);

        ImageButton deleteOne = view.findViewById(R.id.delete_one);
        Button deleteAll = view.findViewById(R.id.delete_all);

        paradigm.setMovementMethod(new ScrollingMovementMethod());

        Controller.zero(zero, paradigm);

        Controller.numPressed(one, "1", paradigm);
        Controller.numPressed(two, "2", paradigm);
        Controller.numPressed(three, "3", paradigm);
        Controller.numPressed(four, "4", paradigm);
        Controller.numPressed(five, "5", paradigm);
        Controller.numPressed(six, "6", paradigm);
        Controller.numPressed(seven, "7", paradigm);
        Controller.numPressed(eight, "8", paradigm);
        Controller.numPressed(nine, "9", paradigm);

        Controller.actionPressed(plus, "+", paradigm);
        Controller.actionPressed(multiplication, "*", paradigm);
        Controller.actionPressed(division, "/", paradigm);
        Controller.actionPressed(perCent, "%", paradigm);

        Controller.minus(minus, paradigm);

        Controller.sin(sin, paradigm, "sin(", "sin");
        Controller.sin(cos, paradigm, "cos(", "cos");

        Controller.equal(equal, paradigm, history,scrollView);
        Controller.coma(coma, paradigm, ",");

        Controller.deleteOne(deleteOne, paradigm);
        Controller.deleteAll(deleteAll, paradigm);

        loadText(history);

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        saveText(history);
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

    public void saveText(@NonNull TextView history) {
        sPref = requireActivity().getSharedPreferences("UltraProject", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT, history.getText().toString());
        ed.apply();
    }

    public void loadText(@NonNull TextView history) {
        sPref = requireActivity().getSharedPreferences("UltraProject", MODE_PRIVATE);
        String savedText = sPref.getString(SAVED_TEXT, "");
        history.setText(savedText);
    }
}

