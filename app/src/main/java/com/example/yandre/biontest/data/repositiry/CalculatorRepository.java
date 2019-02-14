package com.example.yandre.biontest.data.repositiry;

import com.example.yandre.biontest.data.pojo.CalculateH2O;

import java.util.List;

import io.reactivex.Single;

public interface CalculatorRepository {

    Single<List<CalculateH2O>> getDataH2O(long id);

    Single<List<CalculateH2O>> getDataH2O(long id);

}
