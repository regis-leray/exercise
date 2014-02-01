package org.rayjars.salestaxes.formater;

/**
 * Created with IntelliJ IDEA.
 * User: regis
 * Date: 14-01-31
 * Time: 19:29
 * To change this template use File | Settings | File Templates.
 */
public interface StringFormatter<T> {
    public String toString(Integer index, T product);


}
