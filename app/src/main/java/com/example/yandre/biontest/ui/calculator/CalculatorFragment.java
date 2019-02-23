package com.example.yandre.biontest.ui.calculator;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yandre.biontest.R;
import com.example.yandre.biontest.databinding.FragmentCalculatorBinding;
import com.example.yandre.biontest.pojo.CalculateN;
import com.example.yandre.biontest.pojo.ElementModel;

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
        changeElementsTextSize();

        return binding.getRoot();
    }

    @Override
    public void changeElementsTextSize() {
        String k2O = binding.calculatorIncluded.tvK2OFrgCalculator.getSubtitleText();
        Spannable newk2O = new SpannableString(k2O);
        newk2O.setSpan(new RelativeSizeSpan(0.6f),1,2, 0);
        binding.calculatorIncluded.tvK2OFrgCalculator.setSubtitleText(newk2O);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        calculatorPresenter.getCalculatorData();
    }

    @Override
    public void displayData(List<ElementModel> list) {
        for (ElementModel element : list) {
            switch (element.getElement()) {
                case N:
                    binding.calculatorIncluded.tvNFrgCalculator
                            .setValueElement(String.valueOf(element.getValue()));
                    break;
                case P2O5:
                    binding.calculatorIncluded.tvP2O5FrgCalculator
                            .setValueElement(String.valueOf(element.getValue()));
                    break;
                case K2O:
                    binding.calculatorIncluded.tvK2OFrgCalculator
                            .setValueElement(String.valueOf(element.getValue()));
                    break;
                case CaO:
                    binding.calculatorIncluded.tvCaFrgCalculator
                            .setValueElement(String.valueOf(element.getValue()));
                    break;
                case MgO:
                    binding.calculatorIncluded.tvMgFrgCalculator
                            .setValueElement(String.valueOf(element.getValue()));
                    break;
                case S:
                    binding.calculatorIncluded.tvSFrgCalculator
                            .setValueElement(String.valueOf(element.getValue()));
                    break;
                case H2O:
                    binding.calculatorIncluded.tvH2OFrgCalculator
                            .setValueElement(String.valueOf(element.getValue()));
                    break;
            }
        }
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        calculatorPresenter.onDestroy();
    }
}
