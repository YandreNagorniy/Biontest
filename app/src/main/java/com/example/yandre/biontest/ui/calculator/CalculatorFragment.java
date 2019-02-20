package com.example.yandre.biontest.ui.calculator;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.yandre.biontest.R;
import com.example.yandre.biontest.databinding.FragmentCalculatorBinding;
import com.example.yandre.biontest.pojo.CalculateN;

import java.util.List;

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

        calculatorPresenter.getData();
//        binding.calculatorIncluded.tvH2OFrgCalculator

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        calculatorPresenter.getData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        calculatorPresenter.onDestroy();
    }

    @Override
    public void displayData(List<CalculateN> list) {
        int a = 0;
        // binding.toolbarFragCalculator.setTitle(String.valueOf(list.size()));
    }

    @Override
    public void setN(double n) {
        Toast.makeText(getContext(), String.valueOf(n), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getContext(),message,Toast.LENGTH_LONG).show();
    }
}
