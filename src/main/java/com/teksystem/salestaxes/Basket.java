package com.teksystem.salestaxes;

import java.util.ArrayList;
import java.util.List;


public class Basket {

    private List<Group> groups = null;

    public void addGroup(Group group){
        getGroups().add(group);
    }

    public List<Group> getGroups() {
        if(groups == null){
            groups = new ArrayList<Group>();
        }
        return groups;
    }

    public static class Group{
        List<Product> products = null;

        public List<Product> getProducts() {
            if(products == null){
                products = new ArrayList<Product>();
            }
            return products;
        }
    }
}
