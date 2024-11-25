package Controller;

import Model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentManagement {
    private List<Student> studentList = new ArrayList<>();

    // Nhập danh sách học sinh từ file .txt
    public void loadStudentsFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader("src\\data\\students.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 7) {
                    String studentId = data[0];
                    String name = data[1];
                    String dob = data[2];
                    String gender = data[3];
                    String className = data[4];
                    String address = data[5];
                    double gpa = Double.parseDouble(data[6]);
                    Student student = new Student(studentId, name, dob, gender, className, address, gpa);
                    studentList.add(student);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Hiển thị danh sách học sinh
    public List<Student> getAllStudents() {
        return (List<Student>) studentList;
    }

    // Thêm học sinh mới
    public void addStudent(Student student) {
        studentList.add(student);
    }

    // Sửa thông tin học sinh
    public void editStudent(String studentId, String newName, String newClass, String newAddress, double newGpa) {
        for (Student student : studentList) {
            if (student.getStudentId().equalsIgnoreCase(studentId)) {
                student.setName(newName);
                student.setClassName(newClass);
                student.setAddress(newAddress);
                student.setGpa(newGpa);
                break;
            }
        }
    }

    public List<Student> findStudentById(String studentId) {
        List<Student> result = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getStudentId().equalsIgnoreCase(studentId)) {
                result.add(student);
            }
        }
        return result;
    }

    // Xóa học sinh
    public void deleteStudent(String studentId) {
        studentList.removeIf(student -> student.getStudentId().equalsIgnoreCase(studentId));
    }

    // Hiển thị top 3 học sinh
    public List<Student> getTop3Students() {
        return studentList.stream()
                .sorted((s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa()))
                .limit(3)
                .toList();
    }
    public List<Student> findStudentsByName(String name) {
        List<Student> result = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(student);
            }
        }
        return result;
    }

    public List<Student> findStudentByName(String searchStudentName) {
        return studentList.stream()
                .filter(student -> student.getName().toLowerCase().contains(searchStudentName.toLowerCase()))
                .toList();
    }
}
