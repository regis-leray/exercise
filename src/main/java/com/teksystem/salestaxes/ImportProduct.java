package com.teksystem.salestaxes;

public class ImportProduct extends Product {

    public static final Float DEFAULT_ADDITIONNAL_TAX = 5f;

    private final Float additionalTax;

    public ImportProduct(){
        this(DEFAULT_TAX, DEFAULT_ADDITIONNAL_TAX);
    }

    public ImportProduct(Float tax, Float additionalTax) {
        super(tax);
        this.additionalTax =  additionalTax;
    }

    @Override
    public Float getTax() {
        return super.getTax() + 5f;
    }
}
