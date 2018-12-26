package com.example.yandre.biontest.ui.calculator;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yandre.biontest.R;
import com.example.yandre.biontest.databinding.FragmentCalculator2Binding;
import com.example.yandre.biontest.databinding.FragmentCalculatorBinding;

public class CalculatorFragment2 extends Fragment {
    FragmentCalculator2Binding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_calculator2, container, false);


        return binding.getRoot();
    }
}
