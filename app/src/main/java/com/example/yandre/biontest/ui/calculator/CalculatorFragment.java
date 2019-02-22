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

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        calculatorPresenter.getCalculatorData();
    }

    @Override
    public void fillData(List<ElementModel> list) {
        for (ElementModel element : list) {
            switch (element.getElement()) {
                case N:
                    binding.calculatorIncluded.tvNFrgCalculator
                            .setElement(String.valueOf(element.getValue()));
                    break;
                case P2O5:
                    binding.calculatorIncluded.tvP2O5FrgCalculator
                            .setElement(String.valueOf(element.getValue()));
                    break;
                case K2O:
                    binding.calculatorIncluded.tvK2OFrgCalculator
                            .setElement(String.valueOf(element.getValue()));
                    break;
                case CaO:
                    binding.calculatorIncluded.tvCaFrgCalculator
                            .setElement(String.valueOf(element.getValue()));
                    break;
                case MgO:
                    binding.calculatorIncluded.tvMgFrgCalculator
                            .setElement(String.valueOf(element.getValue()));
                    break;
                case S:
                    binding.calculatorIncluded.tvSFrgCalculator
                            .setElement(String.valueOf(element.getValue()));
                    break;
                case H2O:
                    binding.calculatorIncluded.tvH2OFrgCalculator
                            .setElement(String.valueOf(element.getValue()));
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
