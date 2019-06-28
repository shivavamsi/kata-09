package com.codekata.kataNine;

// imports from JRE Library
import java.util.Scanner;

// imports from com.codekata.util
import com.codekata.util.KataNineUtil;

public class KataApp {

    // Create a Scanner object
    private Scanner scanner = new Scanner(System.in);

    public void startCheckout() {
        // create a CheckOut object
        CheckOut co = new CheckOut(KataNineUtil.getCurrentUnitPricingRule(),
                KataNineUtil.getCurrentSpecialPricingRule());

        System.out.println("Please enter 'N' to terminate scanning");
        System.out.println("Scanning items...");

        while (true) {
            // scan for item
            String item = scanner.nextLine();

            // break loop if 'N' is entered
            if (item.equals("N"))
                break;

            // add item to checkout
            if (!co.scanItem(item))
                System.out.println("Item " + item + " is not available for purchase. Please scan the next Item...");
        }

        System.out.println("Total: " + co.getTotal());
    }

    public static void main(String[] args) {
        // instantiate the application
        KataApp kataApp = new KataApp();

        // start checkout
        kataApp.startCheckout();
    }
}