package com.example.parkme;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.Objects;

public class CategoriesFragment extends Fragment {
    private final String TAG = "CategoriesFragment";
    private final Fragment hourlyFragment = new CategoriesHourlyFragment();
    private final Fragment dailyFragment = new CategoriesDailyFragment();

    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_categories, container, false);

        AppCompatButton btnHourly = (AppCompatButton) view.findViewById(R.id.btn_hourly);
        AppCompatButton btnDaily = (AppCompatButton) view.findViewById(R.id.btn_daily);

        btnDaily.setOnClickListener(v->{
            Log.d(TAG, "click handle");
            setFocus(btnDaily);
            deFocus(btnHourly);
            if (savedInstanceState == null) {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fr_categories_container, dailyFragment).commit();
            }
        });

        btnHourly.setOnClickListener(v->{
            Log.d(TAG, "click handle");
            setFocus(btnHourly);
            deFocus(btnDaily);
            if (savedInstanceState == null) {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fr_categories_container, hourlyFragment).commit();
            }
        });
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fr_categories_container, hourlyFragment).commit();
        }

    }

    private void setFocus(Button button){
        button.setBackgroundResource(R.drawable.btn_primary);
        button.setTextColor(getResources().getColor(R.color.white));
    }

    private void deFocus(Button button){
        button.setBackgroundResource(R.drawable.btn_secondary);
        button.setTextColor(ContextCompat.getColor(requireContext(), R.color.primary_text));
    }
}