package org.rayjars.salestaxes;

import org.rayjars.salestaxes.formater.Formatter;
import org.rayjars.salestaxes.formater.FormatterVisitor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class Basket implements Formatter {

    List<Product> products = null;

    public void addProduct(Product product) {
        this.getProducts().add(product);
    }

    public List<Product> getProducts() {
        if (products == null) {
            products = new ArrayList<Product>();
        }
        return products;
    }

    public BigDecimal totalPriceWithTaxes(){
       BigDecimal value = BigDecimal.ZERO;
        for(Product p: getProducts()){
           value = value.add(p.sellingPrice());
        }

        return value;
    }

    public BigDecimal totalTaxes(){
        BigDecimal value = BigDecimal.ZERO;
        for(Product p: getProducts()){
           value = value.add(p.calculateTax());
        }

        return value;
    }

    public int size(){
        return getProducts().size();
    }


    @Override
    public void accept(Integer index, FormatterVisitor visitor) {
        visitor.visit(index, this);

        for(Product p :getProducts()){
            p.accept(index, visitor);
        }

        visitor.visit(this);

    }
}
