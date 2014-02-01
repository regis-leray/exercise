package org.rayjars.salestaxes;


import org.rayjars.salestaxes.formater.FormatterVisitor;
import org.rayjars.salestaxes.formater.InputFormatterVisitor;
import org.rayjars.salestaxes.formater.OutputFormatterVisitor;

public class Receipt {

    private InputFormatterVisitor inputFormatter;
    private OutputFormatterVisitor outputFormatter;

    public Receipt(){
        setInputFormatter(new InputFormatterVisitor());
        setOutputFormatter(new OutputFormatterVisitor());
    }

    public void setInputFormatter(InputFormatterVisitor inputFormatter) {
        this.inputFormatter = inputFormatter;
    }

    public void setOutputFormatter(OutputFormatterVisitor outputFormatter) {
        this.outputFormatter = outputFormatter;
    }

    public String print(Basket[] baskets) {
        StringBuilder toprint = new StringBuilder();

        toprint.append(build(baskets, inputFormatter));
        toprint.append("\n");
        toprint.append(build(baskets, outputFormatter));

        return toprint.toString();
    }


    private String build(Basket[] baskets, FormatterVisitor visitor) {
        for(Integer index = 0; index < baskets.length; index++){
            baskets[index].accept(index+1, visitor);
        }

        return visitor.format();
    }

}
