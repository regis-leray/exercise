package org.rayjars.salestaxes;


import org.rayjars.salestaxes.calculator.*;
import org.rayjars.salestaxes.formater.Formatter;
import org.rayjars.salestaxes.formater.FormatterVisitor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Product implements Formatter {

    private String name = "";

    private final BigDecimal price;

    private final TaxCalculator calculator;

    public Product(BigDecimal price, TaxCalculator calculator) {
        this.price = price;
        this.calculator = calculator;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal calculateTax(){
        return calculator.calculateTax(getPrice());
    }

    public BigDecimal sellingPrice(){
        return price.add(calculateTax());
    }

    @Override
    public void accept(Integer index, FormatterVisitor visitor) {
        visitor.visit(this);
    }

    public static class Builder {

        private final String name;
        private final BigDecimal originalPrice;
        private final List<TaxCalculator> taxCalculators = new ArrayList<TaxCalculator>();

        public Builder(final String name, final BigDecimal originalPrice) {
            this.name = name;
            this.originalPrice = originalPrice;
        }

        public Builder(final String name, final String originalPrice) throws NumberFormatException {
            this(name, new BigDecimal(originalPrice));
        }

        public Builder addAllTaxCalculators() {
            addSalesTaxCalculator();
            addImportTaxCalculator();
            return this;
        }

        public Builder addNotTaxCalculator(){
            return addTaxCalculator(new NoTaxCalculator());
        }

        public Builder addImportTaxCalculator() {
            return addTaxCalculator(new ImportTaxCalculator());
        }

        public Builder addSalesTaxCalculator() {
            return addTaxCalculator(new SalesTaxCalculator());
        }

        public Builder addTaxCalculator(final TaxCalculator taxCalculator) {
            this.taxCalculators.add(taxCalculator);
            return this;
        }

        public Product build() {
            return new Product(originalPrice, new ChainedTaxCalculator(taxCalculators)).setName(name);
        }
    }

}
