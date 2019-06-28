package com.codekata.kataNine;

// imports from JRE Library
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// imports from com.codekata.model
import com.codekata.model.PricingRule;

public class CheckOut {

    private Map<String, Integer> cart = new HashMap<String, Integer>();
    private PricingRule unitPricingRule;
    private PricingRule specialPricingRule;

    // default constructor
    public CheckOut() {

    }

    // constructor with only unit pricing rule
    public CheckOut(PricingRule unitPricingRule) {
        this.unitPricingRule = unitPricingRule;
    }

    // constructor with unit & special pricing rules
    public CheckOut(PricingRule unitPricingRule, PricingRule specialPricingRule) {
        this.unitPricingRule = unitPricingRule;
        this.specialPricingRule = specialPricingRule;
    }

    // setter for unit pricing rule
    public void setUnitPricingRule(PricingRule unitPricingRule) {
        this.unitPricingRule = unitPricingRule;
    }

    // setter for unit pricing rule
    public void setSpecialPricingRule(PricingRule specialPricingRule) {
        this.specialPricingRule = specialPricingRule;
    }

    public boolean scanItem(String item) {

        // return false if item is not present in unit pricing list
        if (unitPricingRule.getPricing(item) == null)
            return false;

        if (cart.containsKey(item))
            // increment item quantity if item is present in cart
            cart.put(item, cart.get(item) + 1);
        else
            // add item to cart if item is not present in cart
            cart.put(item, 1);

        // return true after successfully adding item to cart
        return true;
    }

    private int calculatePrice(String item, Integer quantity) {
        int price = 0;

        // get special pricing
        List<Integer> specialPricing = specialPricingRule.getPricing(item);

        if (specialPricing != null) {
            int specialPricingQuantity = specialPricing.get(0);
            int specialPrice = specialPricing.get(1);
            // calculate special price on item if applicable
            price += (specialPrice * (quantity / specialPricingQuantity));
            // update quantity
            quantity = quantity % specialPricingQuantity;
        }

        // get unit price
        List<Integer> unitPricing = unitPricingRule.getPricing(item);
        if (unitPricing != null) {
            int unitPrice = unitPricing.get(1);
            // calculate price for individual units
            price += quantity * unitPrice;
        }

        return price;
    }

    public int getTotal() {
        // total price for items in cart
        int total = 0;

        // loop through each item in cart
        for (Map.Entry<String, Integer> entry : cart.entrySet())
            // calculate price for each item
            total += calculatePrice(entry.getKey(), entry.getValue());

        return total;
    }

}