package org.rayjars.salestaxes;


import org.rayjars.salestaxes.formater.FormatterVisitor;
import org.rayjars.salestaxes.formater.InputFormatterVisitor;
import org.rayjars.salestaxes.formater.OutputFormatterVisitor;

public class Receipt {

    public String print(Basket[] baskets) {
        StringBuilder toprint = new StringBuilder();

        toprint.append(build(baskets, new InputFormatterVisitor()));
        toprint.append(build(baskets, new OutputFormatterVisitor()));

        return toprint.toString();
    }


    private String build(Basket[] baskets, FormatterVisitor visitor) {
        for(Integer index = 0; index < baskets.length; index++){
            baskets[index].accept(index+1, visitor);
        }

        return visitor.format();
    }

}
