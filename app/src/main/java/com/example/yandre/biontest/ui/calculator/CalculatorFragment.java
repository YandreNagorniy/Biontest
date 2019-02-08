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

public class CalculatorFragment extends Fragment implements CalculatorView {
    FragmentCalculatorBinding binding;
    CalculatorPresenter calculatorPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_calculator, container, false);
        calculatorPresenter = new CalculatorPresenterImpl(this);

//        binding.calculatorIncluded.tvH2OFrgCalculator
        calculatorPresenter.getCalculatorData();

        return binding.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        calculatorPresenter.onDestroy();
    }
}
