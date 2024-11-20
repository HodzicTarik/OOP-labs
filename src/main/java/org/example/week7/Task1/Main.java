package org.example.week7.Task1;

import java.util.*;

@FunctionalInterface
interface DiscountStrategy {
    double applyDiscount(double price, int quantity);
}

record Product(String name, double price, int quantity) {}

public class Main {

    public static double calculateTotalDiscountedPrice(List<Product> products, DiscountStrategy discountStrategy) {
        double total = 0;
        for (Product product : products) {
            total += discountStrategy.applyDiscount(product.price(), product.quantity());
        }
        return total;
    }

    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 1000.0, 1);
        Product product2 = new Product("Mouse", 50.0, 3);
        Product product3 = new Product("Keyboard", 80.0, 2);
        Product product4 = new Product("Monitor", 200.0, 5);

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);

        DiscountStrategy percentageDiscount = (price, quantity) -> price * 0.90;
        DiscountStrategy fixedDiscount = (price, quantity) -> Math.max(0, price - 20);
        DiscountStrategy bulkDiscount = (price, quantity) -> quantity > 3 ? price * 0.85 : price;

        double totalPercentageDiscount = calculateTotalDiscountedPrice(products, percentageDiscount);
        double totalFixedDiscount = calculateTotalDiscountedPrice(products, fixedDiscount);
        double totalBulkDiscount = calculateTotalDiscountedPrice(products, bulkDiscount);

        System.out.printf("Total with Percentage Discount: %.2f%n", totalPercentageDiscount);
        System.out.printf("Total with Fixed Discount: %.2f%n", totalFixedDiscount);
        System.out.printf("Total with Bulk Discount: %.2f%n", totalBulkDiscount);
    }
}
