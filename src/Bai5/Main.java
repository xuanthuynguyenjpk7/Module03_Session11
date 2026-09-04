package Bai5;

import Bai5.EventManagement;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        EventManagement eventManagement = new EventManagement();

        int choice;

        do {

            System.out.println("\n========== QUẢN LÝ SỰ KIỆN ==========");
            System.out.println("1. Thêm sự kiện");
            System.out.println("2. Hiển thị danh sách sự kiện");
            System.out.println("3. Kiểm tra sự kiện đang diễn ra");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn: ");

            try {

                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1:
                        eventManagement.addEvent();
                        break;

                    case 2:
                        eventManagement.displayEvents();
                        break;

                    case 3:
                        eventManagement.checkCurrentEvents();
                        break;

                    case 0:
                        System.out.println("Thoát chương trình.");
                        break;

                    default:
                        System.out.println("Lựa chọn không hợp lệ!");

                }

            } catch (NumberFormatException e) {

                System.out.println("Vui lòng nhập số!");
                choice = -1;
            }

        } while (choice != 0);

        scanner.close();
    }
}