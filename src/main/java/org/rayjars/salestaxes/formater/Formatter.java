package org.rayjars.salestaxes.formater;


public interface Formatter {
    public void accept(Integer index, FormatterVisitor visitor);
}
