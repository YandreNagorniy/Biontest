package com.example.yandre.biontest.ui.calculator;

import com.example.yandre.biontest.pojo.CalculateN;

import java.util.List;

public interface CalculatorView  {

    void fillData(List<Double> list);

    void displayData(List<CalculateN> list);

    void setN(double n);

    void showError(String message);
}
