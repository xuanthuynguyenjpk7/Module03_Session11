package Bai1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Tạo danh sách số nguyên
        List<Integer> numbers = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        );

        // In ra các số chẵn bằng Lambda Expression
        System.out.println("Các số chẵn:");

        numbers.forEach(number -> {
            if (number % 2 == 0) {
                System.out.println(number);
            }
        });

        // Tính tổng bằng Lambda Expression
        int[] sum = {0};

        numbers.forEach(number -> sum[0] += number);

        System.out.println("Tổng các số: " + sum[0]);
    }
}
