package org.rayjars.salestaxes.formater;

import org.rayjars.salestaxes.Basket;
import org.rayjars.salestaxes.Product;


public interface FormatterVisitor {
    void visit(Integer index, Basket basket);
    void visit(Basket basket);

    void visit(Product product);

    String format();
}
