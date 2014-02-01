package org.rayjars.salestaxes.calculator;


import java.math.BigDecimal;

public class ImportTaxCalculator extends AbstractTaxCalculator {

    public ImportTaxCalculator() {
        super(new BigDecimal("0.05")); //5%
    }

    @Override
    protected BigDecimal calculate(BigDecimal value) {
        return value.multiply(tax);
    }
}
