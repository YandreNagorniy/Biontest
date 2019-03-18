package com.example.yandre.biontest.ui.calculator;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yandre.biontest.R;
import com.example.yandre.biontest.adapters.SoilFactorsAdapter;
import com.example.yandre.biontest.database.model.CalculatorModel;
import com.example.yandre.biontest.databinding.FragmentCalculatorBinding;
import com.example.yandre.biontest.pojo.CalculateN;
import com.example.yandre.biontest.pojo.CalculatorItems;
import com.example.yandre.biontest.pojo.ElementModel;
import com.travijuu.numberpicker.library.Enums.ActionEnum;
import com.travijuu.numberpicker.library.Interface.ValueChangedListener;

import java.util.List;

public class CalculatorFragment extends Fragment implements CalculatorView {

    FragmentCalculatorBinding binding;
    CalculatorPresenter calculatorPresenter;
    public ObservableField<CalculatorItems> model;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_calculator, container, false);
        calculatorPresenter = new CalculatorPresenterImpl(this,
                binding.calculatorIncluded.numbPicker.getValue());
        model = new ObservableField<>();

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        changeElementsTextSize("K2O");
        changeElementsTextSize("H2O");
        changeElementsTextSize("P2O5");
        binding.calculatorIncluded.numbPicker.setValueChangedListener((value, action)
                -> calculatorPresenter.getCalculatorData(value));
    }

    @Override
    public void changeElementsTextSize(String element) {
        Spannable newElement = new SpannableString(element);
        switch (element) {
            case "K2O": {
                newElement.setSpan(new RelativeSizeSpan(0.6f), 1, 2, 0);
                binding.calculatorIncluded.tvK2OFrgCalculator.setSubtitleText(newElement);
            }
            break;
            case "H2O": {
                newElement.setSpan(new RelativeSizeSpan(0.6f), 1, 2, 0);
                binding.calculatorIncluded.tvH2OFrgCalculator.setSubtitleText(newElement);
            }
            break;
            case "P2O5": {
                newElement.setSpan(new RelativeSizeSpan(0.6f), 1, 2, 0);
                newElement.setSpan(new RelativeSizeSpan(0.6f), 3, 4, 0);
                binding.calculatorIncluded.tvP2O5FrgCalculator.setSubtitleText(newElement);
            }
            break;
        }
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
    public void displayData(CalculatorItems calculatorModel) {
        model.set(calculatorModel);
    }

    @Override
    public void onClickCulture() {
//        RecyclerView.Adapter adapter = new SoilFactorsAdapter()
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
