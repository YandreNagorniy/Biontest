package com.example.yandre.biontest.pojo;

public class ElementModel {
    private TypeElement element;
    private double value;

    public ElementModel(TypeElement element, double value) {
        this.element = element;
        this.value = value;
    }

    public TypeElement getElement() {
        return element;
    }

    public void setElement(TypeElement element) {
        this.element = element;
    }


    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
