package Bai5;

import Bai5.Event;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EventManagement {

    private List<Event> events = new ArrayList<>();

    private Scanner scanner = new Scanner(System.in);

    private DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    // Thêm sự kiện
    public void addEvent() {

        System.out.print("Nhập tên sự kiện: ");
        String name = scanner.nextLine();

        LocalDateTime startDate = inputDateTime("Nhập thời gian bắt đầu (dd/MM/yyyy HH:mm): ");

        LocalDateTime endDate = inputDateTime("Nhập thời gian kết thúc (dd/MM/yyyy HH:mm): ");

        // Kiểm tra thời gian
        if (!endDate.isAfter(startDate)) {
            System.out.println("Thời gian kết thúc phải sau thời gian bắt đầu!");
            return;
        }

        Event event = new Event(name, startDate, endDate);

        events.add(event);

        System.out.println("Thêm sự kiện thành công!");
    }

    // Nhập LocalDateTime
    private LocalDateTime inputDateTime(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine();

            try {

                return LocalDateTime.parse(input, formatter);

            } catch (DateTimeParseException e) {

                System.out.println(
                        "Sai định dạng! Vui lòng nhập theo dạng: dd/MM/yyyy HH:mm"
                );
            }
        }
    }

    // Hiển thị danh sách
    public void displayEvents() {

        if (events.isEmpty()) {
            System.out.println("Danh sách sự kiện đang trống!");
            return;
        }

        System.out.println("\n===== DANH SÁCH SỰ KIỆN =====");

        for (Event event : events) {
            System.out.println(event);
        }
    }

    // Kiểm tra sự kiện đang diễn ra
    public void checkCurrentEvents() {

        LocalDateTime now = LocalDateTime.now();

        System.out.println("\n===== SỰ KIỆN ĐANG DIỄN RA =====");

        boolean found = false;

        for (Event event : events) {

            if (!now.isBefore(event.getStartDate())
                    && !now.isAfter(event.getEndDate())) {

                System.out.println(event);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Hiện tại không có sự kiện nào đang diễn ra.");
        }
    }
}
