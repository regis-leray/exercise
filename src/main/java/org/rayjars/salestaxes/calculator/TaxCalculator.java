package org.rayjars.salestaxes.calculator;

import java.math.BigDecimal;

public interface TaxCalculator {
    BigDecimal calculateTax(BigDecimal value);
}
