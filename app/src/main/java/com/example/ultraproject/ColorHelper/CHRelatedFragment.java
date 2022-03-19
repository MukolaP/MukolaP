package com.example.ultraproject.ColorHelper;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.ultraproject.NavigationFragment;
import com.example.ultraproject.R;


public class CHRelatedFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.fragment_color_helper, null);

        FrameLayout choosenColor = view.findViewById(R.id.main_color);
        FrameLayout complementaryColor = view.findViewById(R.id.complementaryColor);
        FrameLayout leftAnalogousColor = view.findViewById(R.id.left_analogous_color);
        FrameLayout centerAnalogousColor = view.findViewById(R.id.center_analogous_color);
        FrameLayout rightAnalogousColor = view.findViewById(R.id.right_analogous_color);
        FrameLayout leftSplitComplementary = view.findViewById(R.id.left_split_complementary);
        FrameLayout centerSplitComplementary = view.findViewById(R.id.center_split_complementary);
        FrameLayout rightSplitComplementary = view.findViewById(R.id.right_split_complementary);
        FrameLayout leftTriadic = view.findViewById(R.id.left_triadic);
        FrameLayout centerTriadic = view.findViewById(R.id.center_triadic);
        FrameLayout rightTriadic= view.findViewById(R.id.right_triadic);

        Button back_to_main = view.findViewById(R.id.back_colorHelper);
        navigation(back_to_main);

        return view;
    }

    @SuppressLint("NonConstantResourceId")
    public void navigation(Button button) {
        button.setOnClickListener(view -> {
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            if (view.getId() == R.id.back_colorHelper) {
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.MainActivity, NavigationFragment.class, null);
                transaction.commit();
            }

        });
    }
}
