package Bai6;

import Bai6.Product;
import Bai6.ProductProcessor;
import Bai6.ProductProcessorImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Tạo danh sách sản phẩm
        List<Product> products = new ArrayList<>();

        products.add(new Product("Laptop", 1200));
        products.add(new Product("Chuột", 50));
        products.add(new Product("Bàn phím", 150));
        products.add(new Product("Tai nghe", 80));
        products.add(new Product("Màn hình", 300));

        // Tạo đối tượng xử lý
        ProductProcessor processor = new ProductProcessorImpl();

        // Kiểm tra sản phẩm đắt tiền
        if (processor.hasExpensiveProduct(products)) {

            System.out.println("===== SẢN PHẨM ĐẮT TIỀN (>100) =====");

            for (Product product : products) {

                if (product.getPrice() > 100) {
                    System.out.println(product);
                }
            }

        } else {
            System.out.println("Không có sản phẩm đắt tiền");
        }

        // Tính tổng giá trị
        double total = processor.calculateTotalValue(products);

        System.out.println("\nTổng giá trị sản phẩm: " + total);

        // In toàn bộ danh sách
        ProductProcessor.printProductList(products);
    }
}
