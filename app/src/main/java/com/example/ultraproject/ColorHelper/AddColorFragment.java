package com.example.ultraproject.ColorHelper;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.ultraproject.R;


public class AddColorFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.fragment_add_color, null);
        Button back = view.findViewById(R.id.back_to_related);
        navigation(back);

        EditText setColor = view.findViewById(R.id.set_color);
        Button addColor = view.findViewById(R.id.add_color);
        addColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorValue.setColor("#"+setColor.getText().toString());
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
                if (view.getId() == R.id.add_color) {
                    transaction.setReorderingAllowed(true);
                    transaction.replace(R.id.MainActivity, CHRelatedFragment.class, null);
                    transaction.commit();
                }

            }
        });

        return view;
    }
    @SuppressLint("NonConstantResourceId")
    public void navigation(Button button) {
        button.setOnClickListener(view -> {
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            if (view.getId() == R.id.back_to_related) {
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.MainActivity, CHRelatedFragment.class, null);
                transaction.commit();
            }
        });
    }
}