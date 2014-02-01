package org.rayjars.salestaxes.calculator;


import java.math.BigDecimal;

public class SalesTaxCalculator extends AbstractTaxCalculator {

    public SalesTaxCalculator() {
        super(new BigDecimal("0.1")); //10%
    }

    @Override
    protected BigDecimal calculate(BigDecimal value) {
        return value.multiply(tax);
    }
}
