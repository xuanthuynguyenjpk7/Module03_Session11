package Bai4;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    // HashMap: key = id, value = Product
    static Map<Integer, Product> products = new HashMap<>();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== PRODUCT MANAGEMENT =====");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Sửa sản phẩm");
            System.out.println("3. Xóa sản phẩm");
            System.out.println("4. Hiển thị danh sách sản phẩm");
            System.out.println("5. Lọc sản phẩm có giá > 100");
            System.out.println("6. Tính tổng giá trị sản phẩm");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addProduct();
                    break;

                case 2:
                    updateProduct();
                    break;

                case 3:
                    deleteProduct();
                    break;

                case 4:
                    displayProducts();
                    break;

                case 5:
                    filterProducts();
                    break;

                case 6:
                    calculateTotalPrice();
                    break;

                case 0:
                    System.out.println("Thoát chương trình!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (choice != 0);
    }

    // =========================
    // 1. THÊM SẢN PHẨM
    // =========================
    public static void addProduct() {

        System.out.print("Nhập ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        // Kiểm tra ID đã tồn tại
        if (products.containsKey(id)) {
            System.out.println("ID đã tồn tại!");
            return;
        }

        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();

        System.out.print("Nhập giá: ");
        double price = scanner.nextDouble();

        Product product = new Product(id, name, price);

        products.put(id, product);

        System.out.println("Thêm sản phẩm thành công!");
    }

    // =========================
    // 2. SỬA SẢN PHẨM
    // =========================
    public static void updateProduct() {

        System.out.print("Nhập ID sản phẩm cần sửa: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Product product = products.get(id);

        if (product == null) {
            System.out.println("Không tìm thấy sản phẩm!");
            return;
        }

        System.out.print("Nhập tên mới: ");
        String name = scanner.nextLine();

        System.out.print("Nhập giá mới: ");
        double price = scanner.nextDouble();

        product.setName(name);
        product.setPrice(price);

        System.out.println("Cập nhật sản phẩm thành công!");
    }

    // =========================
    // 3. XÓA SẢN PHẨM
    // =========================
    public static void deleteProduct() {

        System.out.print("Nhập ID sản phẩm cần xóa: ");
        int id = scanner.nextInt();

        Product removedProduct = products.remove(id);

        if (removedProduct == null) {
            System.out.println("Không tìm thấy sản phẩm!");
        } else {
            System.out.println("Xóa sản phẩm thành công!");
        }
    }

    // =========================
    // 4. HIỂN THỊ SẢN PHẨM
    // =========================
    public static void displayProducts() {

        if (products.isEmpty()) {
            System.out.println("Danh sách sản phẩm đang trống!");
            return;
        }

        System.out.println("\n===== DANH SÁCH SẢN PHẨM =====");

        products.values().forEach(product ->
                System.out.println(product)
        );
    }

    // =========================
    // 5. LỌC GIÁ > 100
    // =========================
    public static void filterProducts() {

        System.out.println("\n===== SẢN PHẨM CÓ GIÁ > 100 =====");

        products.values()
                .stream()
                .filter(product -> product.getPrice() > 100)
                .forEach(product -> System.out.println(product));
    }

    // =========================
    // 6. TÍNH TỔNG GIÁ
    // =========================
    public static void calculateTotalPrice() {

        double total = products.values()
                .stream()
                .mapToDouble(Product::getPrice)
                .sum();

        System.out.println("Tổng giá trị sản phẩm: " + total);
    }
}
