package org.rayjars.salestaxes.formater;

import org.junit.Test;
import org.rayjars.salestaxes.Basket;
import org.rayjars.salestaxes.Product;

public class OutputFormatterVisitorTest {

    OutputFormatterVisitor formatterVisitor = new OutputFormatterVisitor();


    @Test
    public void test(){
        Basket basket = new Basket()
                .addProduct(new Product.Builder("Banana", "1.42").build())
                .addProduct(new Product.Builder("Import shoes", "10.56").addAllTaxCalculators().build())
                .addProduct(new Product.Builder("Book", "10.56").addSalesTaxCalculator().build());

        basket.accept(1, formatterVisitor);

        System.out.println(formatterVisitor.format());

    }
}
