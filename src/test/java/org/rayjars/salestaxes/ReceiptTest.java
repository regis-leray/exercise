package org.rayjars.salestaxes;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class ReceiptTest {

    @Test
    public void print(){
        List<Basket> baskets = new ArrayList<Basket>();

        baskets.add(createFirstBasket());
        baskets.add(createSecondBasket());
        baskets.add(createThirdBasket());


        assertThat(
                new Receipt().print(baskets.toArray(new Basket[0])),
                is("INPUT :\n"+
                "Input 1:\n" +
                "1 book at 12.49\n" +
                "1 music CD at 14.99\n" +
                "1 chocolate at 0.85\n" +

                "Input 2:\n" +
                "1 imported box of chocolates at 10.00\n" +
                "1 imported bottle of perfume at 47.50\n" +

                "Input 3:\n" +
                "1 imported bottle of perfume at 27.99\n" +
                "1 bottle of perfume at 18.99\n" +
                "1 packet of headache pills at 9.75\n" +
                "1 box of imported chocolates at 11.25\n" +

                "\nOUTPUT :\n"+
                "Output 1:\n"+
                "1 book: 13.74\n"+
                "1 music CD: 16.49\n"+
                "1 chocolate: 0.85\n"+
                "Sales Taxes: 2.75\n"+
                "Total: 31.08\n"+

                "Output 2:\n"+
                "1 imported box of chocolates: 10.50\n"+
                "1 imported bottle of perfume: 54.65\n"+
                "Sales Taxes: 7.65\n"+
                "Total: 65.15\n"+

                "Output 3:\n"+
                "1 imported bottle of perfume: 32.19\n"+
                "1 bottle of perfume: 20.89\n"+
                "1 packet of headache pills: 9.75\n"+
                "1 box of imported chocolates: 11.85\n"+
                "Sales Taxes: 6.70\n"+
                "Total: 74.68\n"));

    }




    private Basket createFirstBasket() {
        Basket basket = new Basket();

        basket.addProduct(new Product.Builder("book", "12.49").addSalesTaxCalculator().build());
        basket.addProduct(new Product.Builder("music CD", "14.99").addSalesTaxCalculator().build());
        basket.addProduct(new Product.Builder("chocolate", "0.85").addNotTaxCalculator().build());
        return basket;
    }

    private Basket createSecondBasket() {
        Basket basket = new Basket();

        basket.addProduct(new Product.Builder("imported box of chocolates", "10.00").addImportTaxCalculator().build());
        basket.addProduct(new Product.Builder("imported bottle of perfume", "47.50").addAllTaxCalculators().build());

        return basket;
    }


    private Basket createThirdBasket() {
        Basket basket = new Basket();
        basket.addProduct(new Product.Builder("imported bottle of perfume", "27.99").addAllTaxCalculators().build());
        basket.addProduct(new Product.Builder("bottle of perfume", "18.99").addSalesTaxCalculator().build());
        basket.addProduct(new Product.Builder("packet of headache pills", "9.75").addNotTaxCalculator().build());
        basket.addProduct(new Product.Builder("box of imported chocolates", "11.25").addImportTaxCalculator().build());
        return basket;
    }
}
