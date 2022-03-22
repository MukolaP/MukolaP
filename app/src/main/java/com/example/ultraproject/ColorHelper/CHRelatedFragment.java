package com.example.ultraproject.ColorHelper;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.graphics.Color;

import com.example.ultraproject.NavigationFragment;
import com.example.ultraproject.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class CHRelatedFragment extends Fragment implements View.OnClickListener {

    FrameLayout choosenColor,
                complementaryColor,
                leftAnalogousColor,
                centerAnalogousColor,
                rightAnalogousColor,
                leftSplitComplementary,
                centerSplitComplementary,
                rightSplitComplementary,
                leftTriadic,
                centerTriadic,
                rightTriadic;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.fragment_color_helper, null);

        choosenColor = view.findViewById(R.id.main_color);
        complementaryColor = view.findViewById(R.id.complementaryColor);

        leftAnalogousColor = view.findViewById(R.id.left_analogous_color);
        centerAnalogousColor = view.findViewById(R.id.center_analogous_color);
        rightAnalogousColor = view.findViewById(R.id.right_analogous_color);

        leftSplitComplementary = view.findViewById(R.id.left_split_complementary);
        centerSplitComplementary = view.findViewById(R.id.center_split_complementary);
        rightSplitComplementary = view.findViewById(R.id.right_split_complementary);

        leftTriadic = view.findViewById(R.id.left_triadic);
        centerTriadic = view.findViewById(R.id.center_triadic);
        rightTriadic= view.findViewById(R.id.right_triadic);

        FloatingActionButton floatingActionButton = view.findViewById(R.id.fab);

        Button back_to_main = view.findViewById(R.id.back_colorHelper);
        back_to_main.setOnClickListener(this);
        floatingActionButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        choosenColor.setBackgroundColor(Color.parseColor(ColorValue.getColor()));
        complementaryColor.setBackgroundColor(Color.parseColor(ColorController.complementaryColor(
                ColorValue.red(), ColorValue.green(), ColorValue.blue())));

        leftAnalogousColor.setBackgroundColor(Color.parseColor(ColorController.leftAnalogousColor(
                ColorValue.hsv, ColorValue.red(), ColorValue.green(), ColorValue.blue())));
        rightAnalogousColor.setBackgroundColor(Color.parseColor(ColorController.rightAnalogousColor(
                ColorValue.hsv, ColorValue.red(), ColorValue.green(), ColorValue.blue())));
        centerAnalogousColor.setBackgroundColor(Color.parseColor(ColorValue.getColor()));

        leftSplitComplementary.setBackgroundColor(Color.parseColor(ColorController.leftSplitComplementary(
                ColorValue.hsv, ColorValue.red(), ColorValue.green(), ColorValue.blue())));
        rightSplitComplementary.setBackgroundColor(Color.parseColor(ColorController.rightSplitComplementary(
                ColorValue.hsv, ColorValue.red(), ColorValue.green(), ColorValue.blue())));
        centerSplitComplementary.setBackgroundColor(Color.parseColor(ColorValue.getColor()));

    }

    @Override
    public void onClick(View view) {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        if (view.getId() == R.id.back_colorHelper) {
            transaction.setReorderingAllowed(true);
            transaction.replace(R.id.MainActivity, NavigationFragment.class, null);
            transaction.commit();
        }
        if (view.getId() == R.id.fab){
            transaction.setReorderingAllowed(true);
            transaction.replace(R.id.MainActivity, AddColorFragment.class, null);
            transaction.commit();
        }
    }
}
