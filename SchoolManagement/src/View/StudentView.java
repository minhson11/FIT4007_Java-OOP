package View;

import Model.Student;

import java.util.List;

public class StudentView {
    // Hiển thị danh sách học sinh
    public void displayStudentList(List<Student> studentList) {
        if (studentList.isEmpty()) {
            System.out.println("Không có học sinh nào.");
            return;
        }
        System.out.printf("%-15s %-30s %-15s %-10s %-15s %-30s %-10s%n",
                "Mã HS", "Họ Tên", "Ngày Sinh", "Giới Tính", "Lớp Học", "Địa Chỉ", "Điểm TB");
        for (Student student : studentList) {
            System.out.printf("%-15s %-30s %-15s %-10s %-15s %-30s %-10.2f%n",
                    student.getStudentId(), student.getName(), student.getDob(), student.getGender(),
                    student.getClassName(), student.getAddress(), student.getGpa());
        }
    }

    public void displayTop3Students(List<Student> topStudents) {
        System.out.println("=== TOP 3 HỌC SINH CÓ ĐIỂM CAO NHẤT ===");
        displayStudentList(topStudents);
    }

}
