package Bai2;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // Tạo danh sách 10 sinh viên
        List<Student> students = new ArrayList<>();

        students.add(new Student("Nguyen Van An", 20, 8.5));
        students.add(new Student("Tran Thi Binh", 21, 6.5));
        students.add(new Student("Le Van Cuong", 20, 7.8));
        students.add(new Student("Pham Thi Dung", 22, 9.0));
        students.add(new Student("Hoang Van Em", 19, 5.5));
        students.add(new Student("Do Thi Hoa", 21, 8.2));
        students.add(new Student("Vu Van Long", 20, 7.2));
        students.add(new Student("Bui Thi Mai", 22, 6.8));
        students.add(new Student("Dang Van Nam", 19, 9.5));
        students.add(new Student("Phan Thi Lan", 21, 7.5));

        // Lọc sinh viên có điểm lớn hơn 7.0
        List<Student> filteredStudents = students.stream()
                .filter(student -> student.getGrade() > 7.0)
                .collect(Collectors.toList());

        // Sắp xếp theo tên
        filteredStudents.sort((s1, s2) ->
                s1.getName().compareTo(s2.getName())
        );

        // In danh sách
        System.out.println("Danh sach sinh vien co diem > 7.0:");

        for (Student student : filteredStudents) {
            System.out.println(student);
        }
    }
}