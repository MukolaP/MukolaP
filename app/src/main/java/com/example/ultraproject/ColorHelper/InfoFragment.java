package com.example.ultraproject.ColorHelper;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.ultraproject.R;

public class InfoFragment extends Fragment {

    FrameLayout mainColor;
    TextView hexValue,
            rgbValue,
            hsvValue,
            binaryValue,
            cmykValue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.fragment_info, null);
        mainColor = view.findViewById(R.id.color);
        rgbValue = view.findViewById(R.id.rgb);
        hsvValue = view.findViewById(R.id.hsv);
        binaryValue = view.findViewById(R.id.binary);
        cmykValue = view.findViewById(R.id.cmyk);
        hexValue = view.findViewById(R.id.hex);




        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        hexValue.setText(ColorValue.getColor());
        rgbValue.setText(ColorValue.rgb());
        hsvValue.setText(ColorValue.hsv());
        cmykValue.setText(ColorController.cmyk());
        binaryValue.setText(ColorValue.bin());

    }
}