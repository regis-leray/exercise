package org.rayjars.salestaxes.calculator;

import org.junit.Test;
import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class SalesTaxCalculatorTest {

    private TaxCalculator calculator = new SalesTaxCalculator();

    @Test
    public void calculate() throws Exception {
       assertThat(calculator.calculateTax(new BigDecimal("15")), is(new BigDecimal("1.50")));
    }

    @Test
    public void calculateWithRound() throws Exception {
        assertThat(calculator.calculateTax(new BigDecimal("14.96")), is(new BigDecimal("1.50")));
    }


}
