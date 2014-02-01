package org.rayjars.salestaxes.formater;

import org.rayjars.salestaxes.Basket;
import org.rayjars.salestaxes.Product;

/**
 * Created with IntelliJ IDEA.
 * User: regis
 * Date: 14-01-31
 * Time: 23:31
 * To change this template use File | Settings | File Templates.
 */
public class InputFormatterVisitor implements FormatterVisitor {

    private StringBuilder builder;

    public InputFormatterVisitor(){
        builder = new StringBuilder();
        builder.append("INPUT :").append("\n");
    }

    @Override
    public void visit(Integer index, Basket basket) {
        builder.append("Input "+index).append(":\n");
    }

    @Override
    public void visit(Basket basket) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visit(Product product) {
        builder.append("1")
                .append(" ")
                .append(product.getName())
                .append(" at ")
                .append(product.getPrice())
                .append("\n").toString();
    }

    @Override
    public String format() {
        return builder.toString();  //To change body of implemented methods use File | Settings | File Templates.
    }

}
