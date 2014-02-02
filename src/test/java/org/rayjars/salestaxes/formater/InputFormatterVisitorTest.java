package org.rayjars.salestaxes.formater;

import org.junit.Test;
import org.rayjars.salestaxes.Basket;
import org.rayjars.salestaxes.Product;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * InputFormatterVisitorTest
 * <p/>
 * Author:regis
 * Date: 14-02-01 17:50
 */
public class InputFormatterVisitorTest {

    FormatterVisitor formatterVisitor = new InputFormatterVisitor();


    @Test
    public void test(){
        Basket basket = new Basket()
                .addProduct(new Product.Builder("Banana", "1.42").build())
                .addProduct(new Product.Builder("Import shoes", "30.44").addAllTaxCalculators().build())
                .addProduct(new Product.Builder("Book", "10.56").addSalesTaxCalculator().build());

        basket.accept(1, formatterVisitor);

        assertThat(formatterVisitor.format(), is(
        "INPUT :\n"+
        "Input 1:\n"+
        "1 Banana at 1.42\n"+
        "1 Import shoes at 30.44\n"+
        "1 Book at 10.56\n"));
    }
}
