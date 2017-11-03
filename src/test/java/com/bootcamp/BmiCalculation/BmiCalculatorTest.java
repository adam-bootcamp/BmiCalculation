package com.bootcamp.BmiCalculation;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BmiCalculatorTest {
    private BmiCalculator bmiCalculator;

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] bmiCalculationParameters = {
                {75, 1.8, 23.15, AdultCategory.NORMAL_WEIGHT},
                {100, 2, 25, AdultCategory.PRE_OBESITY},
            { 1, 1, 1, AdultCategory.UNDERWEIGHT },
            { 0, 1, 0, AdultCategory.UNDERWEIGHT },
            { -1, -1, 0, AdultCategory.UNDERWEIGHT },
            { 0, 0, 0, AdultCategory.UNDERWEIGHT },
            { 100, 1.5, 44.44, AdultCategory.OBESITY_CLASS_III },
            { 100, 1.8, 30.86, AdultCategory.OBESITY_CLASS_I },
            { 120, 1.8, 37.04, AdultCategory.OBESITY_CLASS_II },
        };

        return Arrays.asList(bmiCalculationParameters);
    }

    @Parameter(value = 0)
    public double weightInKgs;

    @Parameter(value = 1)
    public double heightInMeters;

    @Parameter(value = 2)
    public double bmiIndex;

    @Parameter(value = 3)
    public AdultCategory category;

    @Before
    public void setUp() throws Exception {
        bmiCalculator = new BmiCalculator();
    }

    @Test
    public void testCalculateBmiShouldCalculateBmi() {
        double calculatedBmiIndex = bmiCalculator.calculateBmi(weightInKgs, heightInMeters);
        assertThat(calculatedBmiIndex).isEqualTo(bmiIndex);
    }

    @Test
    public void testGetBmiCategoryForAdultsShouldReturnBmiForAdults() {
        AdultCategory returnedCategory = bmiCalculator.getBmiCategoryForAdults(bmiIndex);
        assertThat(returnedCategory).isEqualTo(category);
    }

    @Test
    public void testCalculateAdultCategoryShouldReturnCategory() {
        AdultCategory returnedCategory = bmiCalculator.calculateAdultCategory(weightInKgs, heightInMeters);
        assertThat(returnedCategory).isEqualTo(category);
    }
}
