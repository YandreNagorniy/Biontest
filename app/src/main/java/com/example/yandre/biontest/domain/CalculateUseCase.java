package com.example.yandre.biontest.domain;

import com.example.yandre.biontest.data.pojo.CalculateH2O;
import com.example.yandre.biontest.data.repositiry.CalculatorRepository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;

public class CalculateUseCase {
    private CalculatorRepository repository;

    public CalculateUseCase(CalculatorRepository repository) {
        this.repository = repository;
    }

    Single<List<Double>> getData(long id) {
        return repository.getDataH2O(id).flatMap(calculateH2OS -> Single.just(new ArrayList<>()));
    }

}
