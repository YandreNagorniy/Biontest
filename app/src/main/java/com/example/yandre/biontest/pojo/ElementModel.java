package com.example.yandre.biontest.pojo;

public class ElementModel {
    private TypeElement element;
    private int value;

    public ElementModel(TypeElement element, int value) {
        this.element = element;
        this.value = value;
    }

    public TypeElement getElement() {
        return element;
    }

    public void setElement(TypeElement element) {
        this.element = element;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
