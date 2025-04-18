import java.util.*;
import java.util.stream.*;

class Product {
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', category='" + category + "', price=" + price + "}";
    }
}

public class HardLevelProductProcessing {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        
        products.add(new Product("Laptop", "Electronics", 1000.0));
        products.add(new Product("Smartphone", "Electronics", 700.0));
        products.add(new Product("Tablet", "Electronics", 450.0));
        products.add(new Product("Shirt", "Clothing", 40.0));
        products.add(new Product("Jeans", "Clothing", 60.0));
        products.add(new Product("Jacket", "Clothing", 120.0));
        products.add(new Product("Refrigerator", "Appliances", 800.0));
        products.add(new Product("Washing Machine", "Appliances", 500.0));

        Map<String, List<Product>> productsByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));

        System.out.println("Products grouped by category:");
        productsByCategory.forEach((category, productList) -> {
            System.out.println(category + ": " + productList);
        });

        System.out.println("\nMost expensive product in each category:");
        productsByCategory.forEach((category, productList) -> {
            Product mostExpensiveProduct = productList.stream()
                    .max(Comparator.comparingDouble(Product::getPrice))
                    .orElseThrow();
            System.out.println(category + ": " + mostExpensiveProduct);
        });

        double averagePrice = products.stream()
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(0.0);
        
        System.out.println("\nAverage price of all products: " + averagePrice);
    }
}
