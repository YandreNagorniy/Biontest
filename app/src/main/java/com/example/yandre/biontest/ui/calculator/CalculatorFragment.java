package com.example.yandre.biontest.ui.calculator;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yandre.biontest.R;
import com.example.yandre.biontest.databinding.FragmentCalculatorBinding;

import static android.text.Spanned.SPAN_INCLUSIVE_INCLUSIVE;

public class CalculatorFragment extends Fragment {
    FragmentCalculatorBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_calculator, container, false);

        String text1 = "H";
        String text2 = "2";

        SpannableString span1 = new SpannableString(text1);
        span1.setSpan(new AbsoluteSizeSpan(6), 0, text1.length(), SPAN_INCLUSIVE_INCLUSIVE);

        SpannableString span2 = new SpannableString(text2);
        span2.setSpan(new AbsoluteSizeSpan(7), 0, text2.length(), SPAN_INCLUSIVE_INCLUSIVE);




        return binding.getRoot();
    }
}
