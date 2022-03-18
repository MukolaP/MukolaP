package com.example.ultraproject;

import android.widget.Button;

public interface NavigationToFragment {

    default void navigation(Button button){
        button.setOnClickListener(view -> {

        });
    }
}
