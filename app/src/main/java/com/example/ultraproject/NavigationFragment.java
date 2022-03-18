package com.example.ultraproject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ultraproject.Calculator.Calculator;
import com.example.ultraproject.ColorHelper.CHRelatedFragment;

public class NavigationFragment extends Fragment implements NavigationToFragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            getArguments().getString(ARG_PARAM1);
            getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.fragment_main, null);

        Button button_color_helper_fragment = view.findViewById(R.id.bt_color_helper);
        Button button_calculator_fragment = view.findViewById(R.id.fragment_calculator_change);

        navigation(button_color_helper_fragment);
        navigation(button_calculator_fragment);

        return view;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void navigation(Button button) {
        button.setOnClickListener(view -> {
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            switch (view.getId()) {
                case R.id.fragment_calculator_change:
                    transaction.setReorderingAllowed(true);
                    transaction.replace(R.id.MainActivity, Calculator.class, null);
                    transaction.commit();
                    break;
                case R.id.bt_color_helper:
                    transaction.setReorderingAllowed(true);
                    transaction.replace(R.id.MainActivity, CHRelatedFragment.class, null);
                    transaction.commit();
                    break;
            }
        });
    }
}
