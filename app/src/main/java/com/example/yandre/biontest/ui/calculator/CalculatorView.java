package com.example.yandre.biontest.ui.calculator;

import com.example.yandre.biontest.pojo.ElementModel;

import java.util.List;

public interface CalculatorView {

//    void fillData(List<ElementModel> list);

    void displayData(List<ElementModel> list);

    void showError(String message);
}
