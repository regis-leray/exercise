package org.rayjars.salestaxes.calculator;

import java.math.BigDecimal;


public class NoTaxCalculator implements TaxCalculator {
    @Override
    public BigDecimal calculateTax(BigDecimal value) {
        return BigDecimal.ZERO;
    }
}
