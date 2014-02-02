package org.rayjars.salestaxes.formater;

import org.junit.Test;
import org.rayjars.salestaxes.Basket;
import org.rayjars.salestaxes.Product;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OutputFormatterVisitorTest {

    OutputFormatterVisitor formatterVisitor = new OutputFormatterVisitor();


    @Test
    public void test(){
        Basket basket = new Basket()
                .addProduct(new Product.Builder("Banana", "1.42").build())
                .addProduct(new Product.Builder("Import shoes", "30.44").addAllTaxCalculators().build())
                .addProduct(new Product.Builder("Book", "10.56").addSalesTaxCalculator().build());

        basket.accept(1, formatterVisitor);

        assertThat(formatterVisitor.format(), is(
        "OUTPUT :\n" +
        "Output 1:\n" +
        "1 Banana: 1.42\n" +
        "1 Import shoes: 35.04\n" +
        "1 Book: 11.66\n"+
        "Sales Taxes: 5.70\n"+
        "Total: 48.12\n"
        ));

    }
}
