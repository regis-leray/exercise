package org.rayjars.salestaxes.calculator;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class ChainedTaxCalculatorTest {
    private TaxCalculator calculator;

    @Before
    public void create(){
        calculator = new ChainedTaxCalculator(new SalesTaxCalculator(), new ImportTaxCalculator());
    }


    @Test
    public void calculate() throws Exception {
        assertThat(calculator.calculateTax(new BigDecimal("15")), is(new BigDecimal("2.25")));
    }

    @Test
    public void calculateWithRound() throws Exception {
        assertThat(calculator.calculateTax(new BigDecimal("14.97")), is(new BigDecimal("2.25")));
    }
}
