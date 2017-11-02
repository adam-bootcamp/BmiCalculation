package com.bootcamp.BmiCalculation;

import java.text.DecimalFormat;

/**
 * TODO develop unit converter
 */
public class BmiCalculator {
    public double calculateBmi(double weightInKgs, double heightInMeters) {
        double bmi = 0;

        if (heightInMeters > 0 && weightInKgs > 0) {
            bmi = round(weightInKgs / (heightInMeters * heightInMeters));
        }

        return bmi;
    }

    public AdultCategory getBmiCategoryForAdults(double bmi) {
        AdultCategory category;

        if (bmi < 18.5) {
            category = AdultCategory.UNDERWEIGHT;
        } else if (bmi >= 18.5 && bmi < 25) {
            category = AdultCategory.NORMAL_WEIGHT;
        } else if (bmi >= 25 && bmi < 30.0) {
            category = AdultCategory.PRE_OBESITY;
        } else if (bmi >= 30.0 && bmi < 35.0) {
            category = AdultCategory.OBESITY_CLASS_I;
        } else if (bmi >= 35 && bmi < 40) {
            category = AdultCategory.OBESITY_CLASS_II;
        } else {
            category = AdultCategory.OBESITY_CLASS_III;
        }

        return category;
    }

    public AdultCategory calculateAdultCategory(double weightInKgs, double heightInMeters) {
        double bmi = calculateBmi(weightInKgs, heightInMeters);
        AdultCategory category = getBmiCategoryForAdults(bmi);

        return category;
    }

    /**
     * TODO develop calulateChildCategory
     */
    public AdultCategory calculateCategory(int age, double weightInKgs, double heightInMeters) {
        // if(isAdult(age)) {
        return calculateAdultCategory(weightInKgs, heightInMeters);
        // } else {
        //
        // }
    }

    private double round(double number) {
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        return Double.valueOf(twoDForm.format(number));
    }

    private boolean isAdult(int age) {
        return age >= 22;
    }
}
