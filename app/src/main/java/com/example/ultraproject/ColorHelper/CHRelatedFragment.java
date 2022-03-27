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

import com.example.ultraproject.NavigationFragment;
import com.example.ultraproject.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class CHRelatedFragment extends Fragment implements View.OnClickListener {

    public static FrameLayout chosenColor,
                complementaryColor,
                leftAnalogousColor,
                centerAnalogousColor,
                rightAnalogousColor,
                leftSplitComplementary,
                centerSplitComplementary,
                rightSplitComplementary,
                leftTriadic,
                centerTriadic,
                rightTriadic,
                leftTetradic,
                mainTetradic,
                rightTetradic,
                compTetradic;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.fragment_color_helper, container, false);


        chosenColor = view.findViewById(R.id.main_color);
        complementaryColor = view.findViewById(R.id.complementaryColor);

        leftAnalogousColor = view.findViewById(R.id.left_analogous_color);
        centerAnalogousColor = view.findViewById(R.id.center_analogous_color);
        rightAnalogousColor = view.findViewById(R.id.right_analogous_color);

        leftSplitComplementary = view.findViewById(R.id.left_split_complementary);
        centerSplitComplementary = view.findViewById(R.id.center_split_complementary);
        rightSplitComplementary = view.findViewById(R.id.right_split_complementary);

        leftTriadic = view.findViewById(R.id.left_triadic);
        centerTriadic = view.findViewById(R.id.center_triadic);
        rightTriadic = view.findViewById(R.id.right_triadic);

        leftTetradic = view.findViewById(R.id.left_left_tetradic);
        mainTetradic = view.findViewById(R.id.left_center_tetradic);
        rightTetradic = view.findViewById(R.id.right_center_tetradic);
        compTetradic = view.findViewById(R.id.right_right_tetradic);


        FloatingActionButton floatingActionButton = view.findViewById(R.id.fab);

        Button back_to_main = view.findViewById(R.id.back_colorHelper);
        back_to_main.setOnClickListener(this);
        floatingActionButton.setOnClickListener(this);

        change();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        change();
        setMainColor(complementaryColor, 180f, "left");
        setMainColor(leftAnalogousColor, 30f, "left");
        setMainColor(rightAnalogousColor, 30f, "right");
        setMainColor(leftSplitComplementary, 150f, "left");
        setMainColor(rightSplitComplementary, 150f, "right");
        setMainColor(rightTriadic, 120f, "right");
        setMainColor(leftTriadic, 120f, "left");
        setMainColor(leftTetradic, 60f, "left");
        setMainColor(rightTetradic, 120f, "right");
        setMainColor(compTetradic, 180f, "right");
    }
    static void change(){
        ColorController.changeToMain(chosenColor);
        ColorController.rotateLeft(complementaryColor, 180f);
        ColorController.rotateLeft(leftAnalogousColor, 30f);
        ColorController.rotateRight(rightAnalogousColor, 30f);
        ColorController.changeToMain(centerAnalogousColor);
        ColorController.rotateLeft(leftSplitComplementary, 150f);
        ColorController.rotateRight(rightSplitComplementary, 150f);
        ColorController.changeToMain(centerSplitComplementary);
        ColorController.rotateLeft(leftTriadic, 120f);
        ColorController.rotateRight(rightTriadic, 120f);
        ColorController.changeToMain(centerTriadic);
        ColorController.rotateLeft(leftTetradic, 60f);
        ColorController.changeToMain(mainTetradic);
        ColorController.rotateRight(rightTetradic,120f);
        ColorController.rotateRight(compTetradic, 180f);
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
            transaction.replace(R.id.colorHelperActivity, AddColorFragment.class, null);
            transaction.commit();
        }
    }

    public void setMainColor(FrameLayout frameLayout, float rotation, String direction){
        frameLayout.setOnClickListener(view -> {
            switch (direction){
                case "left":
                    ColorValue.setColor(ColorController.leftRotated(rotation));
                    change();
                    break;
                case "right":
                    ColorValue.setColor(ColorController.rightRotated(rotation));
                    change();
                    break;
            }
        });
    }
}
