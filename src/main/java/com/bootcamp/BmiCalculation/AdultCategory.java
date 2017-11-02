package com.bootcamp.BmiCalculation;

public enum AdultCategory {
    UNDERWEIGHT("Underweight"),
    NORMAL_WEIGHT("Normal weight"),
    PRE_OBESITY("Pre-obesity"),
    OBESITY_CLASS_I("Obesity class I"),
    OBESITY_CLASS_II("Obesity class II"),
    OBESITY_CLASS_III("Obesity class III");
    
    private String categoryName;

    private AdultCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return categoryName;
    }
}
