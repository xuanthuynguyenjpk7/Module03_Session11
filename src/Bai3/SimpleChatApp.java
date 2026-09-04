package Bai3;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Message {
    private String sender;
    private String content;
    private LocalDateTime timestamp;

    public Message(String sender, String content, LocalDateTime timestamp) {
        this.sender = sender;
        this.content = content;
        this.timestamp = timestamp;
    }

    public String getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        return "[" + timestamp.format(formatter) + "] "
                + sender + ": " + content;
    }
}

public class SimpleChatApp {

    static List<Message> messages = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);

    static DateTimeFormatter dateFormatter =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== SIMPLE CHAT APP =====");
            System.out.println("1. Gửi tin nhắn");
            System.out.println("2. Xem lịch sử chat");
            System.out.println("3. Lọc tin nhắn theo người gửi");
            System.out.println("4. Lọc tin nhắn theo ngày");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        sendMessage();
                        break;

                    case 2:
                        showHistory();
                        break;

                    case 3:
                        filterBySender();
                        break;

                    case 4:
                        filterByDate();
                        break;

                    case 5:
                        System.out.println("Đã thoát chương trình.");
                        break;

                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
                choice = 0;
            }

        } while (choice != 5);

        scanner.close();
    }

    // Gửi tin nhắn
    public static void sendMessage() {

        System.out.print("Nhập tên người gửi: ");
        String sender = scanner.nextLine();

        System.out.print("Nhập nội dung tin nhắn: ");
        String content = scanner.nextLine();

        Message message = new Message(
                sender,
                content,
                LocalDateTime.now()
        );

        messages.add(message);

        System.out.println("Gửi tin nhắn thành công!");
    }

    // Xem lịch sử chat
    public static void showHistory() {

        if (messages.isEmpty()) {
            System.out.println("Chưa có tin nhắn nào.");
            return;
        }

        System.out.println("\n===== LỊCH SỬ CHAT =====");

        messages.forEach(System.out::println);
    }

    // Lọc theo người gửi
    public static void filterBySender() {

        System.out.print("Nhập tên người gửi cần tìm: ");
        String sender = scanner.nextLine();

        List<Message> result = messages.stream()
                .filter(message ->
                        message.getSender().equalsIgnoreCase(sender))
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("Không tìm thấy tin nhắn.");
        } else {
            System.out.println("\n===== KẾT QUẢ =====");

            result.forEach(System.out::println);
        }
    }

    // Lọc theo ngày
    public static void filterByDate() {

        System.out.print("Nhập ngày cần tìm (dd/MM/yyyy): ");
        String dateInput = scanner.nextLine();

        try {

            LocalDate date =
                    LocalDate.parse(dateInput, dateFormatter);

            List<Message> result = messages.stream()
                    .filter(message ->
                            message.getTimestamp()
                                    .toLocalDate()
                                    .equals(date))
                    .collect(Collectors.toList());

            if (result.isEmpty()) {
                System.out.println("Không có tin nhắn trong ngày này.");
            } else {

                System.out.println("\n===== TIN NHẮN NGÀY "
                        + dateInput + " =====");

                result.forEach(System.out::println);
            }

        } catch (DateTimeParseException e) {

            System.out.println(
                    "Ngày không đúng định dạng! "
                            + "Vui lòng nhập theo dd/MM/yyyy."
            );
        }
    }
}
