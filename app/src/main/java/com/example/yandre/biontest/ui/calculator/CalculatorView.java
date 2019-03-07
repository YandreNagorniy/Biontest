package com.example.yandre.biontest.ui.calculator;

import com.example.yandre.biontest.pojo.CalculatorItems;
import com.example.yandre.biontest.pojo.ElementModel;

import java.util.List;

public interface CalculatorView {

    void displayData(List<ElementModel> list);

    void changeElementsTextSize(String element);

    void displayData(CalculatorItems calculatorModel);

    void showError(String message);
}
