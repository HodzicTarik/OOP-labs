package org.example.week7.Task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

    public record Sale(String productCategory, double revenue, int year, int month, int day) {
    }

    public static class SalesReport {

        public void generateReport(List<Sale> sales) {
            double totalRevenue = 0;
            System.out.println("Full Sales Report:");
            for (Sale sale : sales) {
                totalRevenue += sale.revenue();
                System.out.println("Category: " + sale.productCategory() +
                        ", Revenue: " + sale.revenue() +
                        ", Date: " + sale.year() + "-" + sale.month() + "-" + sale.day());
            }
            System.out.println("Total Revenue: " + totalRevenue);
        }

        public void generateReport(List<Sale> sales, String productCategory) {
            double totalRevenue = 0;
            System.out.println("Sales Report for Category: " + productCategory);
            for (Sale sale : sales) {
                if (sale.productCategory().equals(productCategory)) {
                    totalRevenue += sale.revenue();
                    System.out.println("Revenue: " + sale.revenue() +
                            ", Date: " + sale.year() + "-" + sale.month() + "-" + sale.day());
                }
            }
            System.out.println("Total Revenue for " + productCategory + ": " + totalRevenue);
        }

        public void generateReport(List<Sale> sales, int startYear, int startMonth, int endYear, int endMonth) {
            double totalRevenue = 0;
            System.out.println("Sales Report for Date Range: " +
                    startYear + "-" + startMonth + " to " + endYear + "-" + endMonth);
            for (Sale sale : sales) {
                if (isWithinRange(sale, startYear, startMonth, endYear, endMonth)) {
                    totalRevenue += sale.revenue();
                    System.out.println("Category: " + sale.productCategory() +
                            ", Revenue: " + sale.revenue() +
                            ", Date: " + sale.year() + "-" + sale.month() + "-" + sale.day());
                }
            }
            System.out.println("Total Revenue for Date Range: " + totalRevenue);
        }

        private boolean isWithinRange(Sale sale, int startYear, int startMonth, int endYear, int endMonth) {
            int saleDate = sale.year() * 100 + sale.month();
            int startDate = startYear * 100 + startMonth;
            int endDate = endYear * 100 + endMonth;
            return saleDate >= startDate && saleDate <= endDate;
        }

        public Optional<Double> calculateAverageRevenue(List<Sale> sales) {
            if (sales.isEmpty()) return Optional.empty();
            double totalRevenue = 0;
            for (Sale sale : sales) {
                totalRevenue += sale.revenue();
            }
            return Optional.of(totalRevenue / sales.size());
        }
    }

    public static void main(String[] args) {
        List<Sale> sales = new ArrayList<>();
        sales.add(new Sale("Electronics", 1500.0, 2023, 11, 15));
        sales.add(new Sale("Clothing", 300.0, 2023, 10, 5));
        sales.add(new Sale("Groceries", 120.0, 2023, 9, 25));
        sales.add(new Sale("Electronics", 2000.0, 2023, 8, 10));
        sales.add(new Sale("Clothing", 500.0, 2023, 7, 18));

        SalesReport report = new SalesReport();

        report.generateReport(sales);
        report.generateReport(sales, "Electronics");
        report.generateReport(sales, 2023, 8, 2023, 11);

        Optional<Double> averageRevenue = report.calculateAverageRevenue(sales);
        averageRevenue.ifPresent(avg -> System.out.println("Average Revenue: " + avg));
    }
}
