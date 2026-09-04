package Bai6;

import Bai6.Product;

import java.util.List;
import java.util.function.Predicate;

public interface ProductProcessor {

    // Phương thức abstract
    double calculateTotalValue(List<Product> products);

    // Phương thức static
    static void printProductList(List<Product> products) {
        System.out.println("\n===== DANH SÁCH SẢN PHẨM =====");

        for (Product product : products) {
            System.out.println(product);
        }
    }

    // Phương thức default
    default boolean hasExpensiveProduct(List<Product> products) {

        Predicate<Product> expensiveProduct =
                product -> product.getPrice() > 100;

        for (Product product : products) {
            if (expensiveProduct.test(product)) {
                return true;
            }
        }

        return false;
    }
}