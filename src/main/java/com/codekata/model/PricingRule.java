package com.codekata.model;

// imports from JRE Library
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PricingRule {

    private Map<String, List<Integer>> priceList = new HashMap<String, List<Integer>>();

    public void addPricing(String item, int quantity, int price) {
        // create a List of quantity and corresponding price for item
        List<Integer> pricing = new ArrayList<Integer>();

        // add quantity
        pricing.add(quantity);
        // add its corresponding price in cents
        pricing.add(price);

        // add pricing for item to priceList
        priceList.put(item, pricing);
    }

    public void addPricing(String item, int price) {
        // create a map of default quantity 1 and corresponding price for item
        List<Integer> pricing = new ArrayList<Integer>();

        // add default quantity of 1
        pricing.add(1);
        // add its corresponding price in cents
        pricing.add(price);

        // add pricing for item to priceList
        priceList.put(item, pricing);
    }

    public List<Integer> getPricing(String item) {
        // return a map of quantity and price for requested item
        return priceList.get(item);
    }

}