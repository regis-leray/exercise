package org.rayjars.salestaxes.formater;

import org.rayjars.salestaxes.Basket;
import org.rayjars.salestaxes.Product;

/**
 * Created with IntelliJ IDEA.
 * User: regis
 * Date: 14-01-31
 * Time: 23:33
 * To change this template use File | Settings | File Templates.
 */
public interface FormatterVisitor {
    void visit(Integer index, Basket basket);
    void visit(Basket basket);

    void visit(Product product);

    String format();
}
