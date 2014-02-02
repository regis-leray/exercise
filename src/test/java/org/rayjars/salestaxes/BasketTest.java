package org.rayjars.salestaxes;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BasketTest {

    private Basket basket;

    @Before
    public void createBasket() {
        basket = new Basket();

    }

    @Test
    public void calculateTotalPriceWithTaxes(){

        basket.addProduct(new Product.Builder("Book", "12.49").addNotTaxCalculator().build());
        basket.addProduct(new Product.Builder("Music cd", "14.99").addSalesTaxCalculator().build());
        basket.addProduct(new Product.Builder("Chocolate bar", "0.85").addNotTaxCalculator().build());


        assertThat(basket.size(), is(3));
        assertThat(basket.totalPriceWithTaxes(), is(new BigDecimal("29.83")));
        assertThat(basket.totalTaxes(), is(new BigDecimal("1.50")));
    }



    @Test
    public void calculateTotalWithImportProduct(){
        basket.addProduct(new Product.Builder("imported box of chocolates", "10.00").addImportTaxCalculator().build());
        basket.addProduct(new Product.Builder("imported bottle of perfume ", "47.50").addAllTaxCalculators().build());

        assertThat(basket.size(), is(2));
        assertThat(basket.totalPriceWithTaxes(), is(new BigDecimal("65.15")));
        assertThat(basket.totalTaxes(), is(new BigDecimal("7.65")));
    }

    @Test
    public void calculateTotalWithMixProduct(){

        basket.addProduct(new Product.Builder("imported bottle of perfume", "27.99").addAllTaxCalculators().build());
        basket.addProduct(new Product.Builder("bottle of perfume", "18.99").addSalesTaxCalculator().build());
        basket.addProduct(new Product.Builder("packet of headache pills", "9.75").addNotTaxCalculator().build());
        basket.addProduct(new Product.Builder("box of imported chocolates", "11.25").addImportTaxCalculator().build());

        assertThat(basket.size(), is(4));
        assertThat(basket.totalTaxes(), is(new BigDecimal("6.70")));
        assertThat(basket.totalPriceWithTaxes(), is(new BigDecimal("74.68")));
    }


}
