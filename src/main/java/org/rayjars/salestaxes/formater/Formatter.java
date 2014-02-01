package org.rayjars.salestaxes.formater;

/**
 * Created with IntelliJ IDEA.
 * User: regis
 * Date: 14-01-31
 * Time: 23:41
 * To change this template use File | Settings | File Templates.
 */
public interface Formatter {
    public void accept(Integer index, FormatterVisitor visitor);
}
