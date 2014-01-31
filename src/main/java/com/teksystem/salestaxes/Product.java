package com.teksystem.salestaxes;


public class Product {
    public static final Float DEFAULT_TAX = 10f;

    private String name = "";

    private Float price = 0f;

    private Float tax = 0f;

    private Integer quantity = 1;

    public Product() {
        this(DEFAULT_TAX);
    }

    public Product(Float tax) {
        this.tax = tax;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public Float getPrice() {
        return price;
    }

    public Product setPrice(Float price) {
        this.price = price;
        return this;
    }

    public Product setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    private Integer getQuantity() {
        return quantity;
    }

    public Float getTax(){
          return tax;
    }

    public Float calculateTax(){
        return ((getPrice() * getQuantity()) * getTax()) / 100;
    }

    public Float calculatePriceWithTax(){
        return (getPrice() * getQuantity()) + calculateTax();
    }

    public String toString(){
        return new StringBuilder()
                .append(getQuantity())
                .append(" ")
                .append(getName())
                .append(" at ")
                .append(getPrice().toString()).toString();
    }

    public String toShortString(){
        return new StringBuilder()
                .append(getQuantity())
                .append(" ")
                .append(getName())
                .append(" : ")
                .append(getPrice().toString()).toString();
    }




}
