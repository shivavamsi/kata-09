package com.codekata.util;

// imports from com.codekata.model
import com.codekata.model.PricingRule;

public class KataNineUtil {

    public static PricingRule getCurrentUnitPricingRule() {
        // create new rule
        PricingRule unitPricingRule = new PricingRule();

        // add unit pricing for each item
        // Item | Price
        unitPricingRule.addPricing("A", 50);
        unitPricingRule.addPricing("B", 30);
        unitPricingRule.addPricing("C", 20);
        unitPricingRule.addPricing("D", 15);

        return unitPricingRule;
    }

    public static PricingRule getCurrentSpecialPricingRule() {
        // create new rule
        PricingRule specialPricingRule = new PricingRule();

        // special unit pricing for each item
        // Item | Quantity | Price
        specialPricingRule.addPricing("A", 3, 130);
        specialPricingRule.addPricing("B", 2, 45);

        return specialPricingRule;
    }
}