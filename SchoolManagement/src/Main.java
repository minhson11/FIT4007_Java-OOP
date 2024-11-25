import Controller.ClassRoomManagement;
import Controller.StudentManagement;
import Controller.TeacherManagement;
import Model.ClassRoom;
import Model.Student;
import Model.Teacher;
import View.ClassView;
import View.StudentView;
import View.TeacherView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClassRoomManagement classRoomManager = new ClassRoomManagement();
        StudentManagement studentManager = new StudentManagement();
        TeacherManagement teacherManager = new TeacherManagement();
        ClassView classView = new ClassView();
        StudentView studentView = new StudentView();
        TeacherView teacherView = new TeacherView();

        // Tải dữ liệu từ file
        classRoomManager.loadClassRoomsFromFile("data/classrooms.txt");
        studentManager.loadStudentsFromFile("data/students.txt");
        teacherManager.loadTeachersFromFile("data/teachers.txt");

        int choice;
        do {
            System.out.println("=== HỆ THỐNG QUẢN LÝ TRƯỜNG HỌC ===");
            System.out.println("1. Quản lý lớp học");
            System.out.println("2. Quản lý học sinh");
            System.out.println("3. Quản lý giáo viên");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1: // Quản lý lớp học
                    manageClassRoom(scanner, classRoomManager, classView);
                    break;
                case 2: // Quản lý học sinh
                    manageStudent(scanner, studentManager, studentView);
                    break;
                case 3: // Quản lý giáo viên
                    manageTeacher(scanner, teacherManager, teacherView);
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        } while (choice != 0);
    }

    private static void manageClassRoom(Scanner scanner, ClassRoomManagement classRoomManager, ClassView classView) {
        int classChoice;
        do {
            System.out.println("=== QUẢN LÝ LỚP HỌC ===");
            System.out.println("1. Hiển thị danh sách lớp học");
            System.out.println("2. Thêm lớp học mới");
            System.out.println("3. Sửa thông tin lớp học");
            System.out.println("4. Tìm lớp học theo tên");
            System.out.println("5. Xóa lớp học");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            classChoice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (classChoice) {
                case 1:
                    classView.displayClassRoomList(classRoomManager.getAllClassRooms());
                    break;
                case 2:
                    System.out.print("Nhập tên lớp: ");
                    String className = scanner.nextLine();
                    System.out.print("Nhập khối học: ");
                    String grade = scanner.nextLine();
                    System.out.print("Nhập giáo viên chủ nhiệm: ");
                    String teacher = scanner.nextLine();
                    System.out.print("Nhập số lượng học sinh: ");
                    int studentCount = scanner.nextInt();
                    classRoomManager.addClassRoom(new ClassRoom(className, grade, teacher, studentCount));
                    break;
                case 3:
                    System.out.print("Nhập tên lớp cần sửa: ");
                    String editClassName = scanner.nextLine();
                    System.out.print("Nhập tên giáo viên mới: ");
                    String newTeacher = scanner.nextLine();
                    System.out.print("Nhập số lượng học sinh mới: ");
                    int newStudentCount = scanner.nextInt();
                    classRoomManager.editClassRoom(editClassName, newTeacher, newStudentCount);
                    break;
                case 4:
                    System.out.print("Nhập tên lớp cần tìm: ");
                    String searchClassName = scanner.nextLine();
                    classView.displayClassRoom(classRoomManager.findClassRoomByName(searchClassName));
                    break;
                case 5:
                    System.out.print("Nhập tên lớp cần xóa: ");
                    String deleteClassName = scanner.nextLine();
                    classRoomManager.deleteClassRoom(deleteClassName);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        } while (classChoice != 0);
    }

    private static void manageStudent(Scanner scanner, StudentManagement studentManager, StudentView studentView) {
        int studentChoice;
        do {
            System.out.println("=== QUẢN LÝ HỌC SINH ===");
            System.out.println("1. Hiển thị danh sách học sinh");
            System.out.println("2. Thêm học sinh mới");
            System.out.println("3. Sửa thông tin học sinh");
            System.out.println("4. Tìm học sinh theo mã");
            System.out.println("5. Tìm học sinh theo tên");
            System.out.println("6. Xóa học sinh");
            System.out.println("7. Hiển thị top 3 học sinh có điểm cao nhất");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            studentChoice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (studentChoice) {
                case 1:
                    studentView.displayStudentList(studentManager.getAllStudents());
                    break;
                case 2:
                    System.out.print("Nhập mã học sinh: ");
                    String studentId = scanner.nextLine();
                    System.out.print("Nhập họ tên: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập ngày sinh: ");
                    String dob = scanner.nextLine();
                    System.out.print("Nhập giới tính: ");
                    String gender = scanner.nextLine();
                    System.out.print("Nhập lớp học: ");
                    String className = scanner.nextLine();
                    System.out.print("Nhập địa chỉ: ");
                    String address = scanner.nextLine();
                    System.out.print("Nhập điểm trung bình: ");
                    double gpa = scanner.nextDouble();
                    studentManager.addStudent(new Student(studentId, name, dob, gender, className, address, gpa));
                    break;
                case 3:
                    System.out.print("Nhập mã học sinh cần sửa: ");
                    String editStudentId = scanner.nextLine();
                    System.out.print("Nhập tên mới: ");
                    String newName = scanner.nextLine();
                    System.out.print("Nhập lớp mới: ");
                    String newClassName = scanner.nextLine();
                    System.out.print("Nhập địa chỉ mới: ");
                    String newAddress = scanner.nextLine();
                    System.out.print("Nhập điểm trung bình mới: ");
                    double newGpa = scanner.nextDouble();
                    studentManager.editStudent(editStudentId, newName, newClassName, newAddress, newGpa);
                    break;
                case 4:
                    System.out.print("Nhập mã học sinh cần tìm: ");
                    String searchStudentId = scanner.nextLine();
                    studentView.displayStudentList(studentManager.findStudentById(searchStudentId));
                    break;
                case 5:
                    System.out.print("Nhập tên học sinh cần tìm: ");
                    String searchStudentName = scanner.nextLine();
                    studentView.displayStudentList(studentManager.findStudentByName(searchStudentName));
                    break;
                case 6:
                    System.out.print("Nhập mã học sinh cần xóa: ");
                    String deleteStudentId = scanner.nextLine();
                    studentManager.deleteStudent(deleteStudentId);
                    break;
                case 7:
                    studentView.displayTop3Students(studentManager.getTop3Students());
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        } while (studentChoice != 0);
    }

    private static void manageTeacher(Scanner scanner, TeacherManagement teacherManager, TeacherView teacherView) {
        int teacherChoice;
        do {
            System.out.println("=== QUẢN LÝ GIÁO VIÊN ===");
            System.out.println("1. Hiển thị danh sách giáo viên");
            System.out.println("2. Thêm giáo viên mới");
            System.out.println("3. Sửa thông tin giáo viên");
            System.out.println("4. Tìm giáo viên theo mã");
            System.out.println("5. Xóa giáo viên");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            teacherChoice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (teacherChoice) {
                case 1:
                    teacherView.displayTeacherList(teacherManager.getAllTeachers());
                    break;
                case 2:
                    System.out.print("Nhập mã giáo viên: ");
                    String teacherId = scanner.nextLine();
                    System.out.print("Nhập họ tên: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập ngày sinh: ");
                    String dob = scanner.nextLine();
                    System.out.print("Nhập giới tính: ");
                    String gender = scanner.nextLine();
                    System.out.print("Nhập môn dạy: ");
                    String subject = scanner.nextLine();
                    System.out.print("Nhập địa chỉ: ");
                    String address = scanner.nextLine();
                    teacherManager.addTeacher(new Teacher(teacherId, name, dob, gender, subject, address));
                    break;
                case 3:
                    System.out.print("Nhập mã giáo viên cần sửa: ");
                    String editTeacherId = scanner.nextLine();
                    System.out.print("Nhập tên mới: ");
                    String newName = scanner.nextLine();
                    System.out.print("Nhập môn mới: ");
                    String newSubject = scanner.nextLine();
                    System.out.print("Nhập địa chỉ mới: ");
                    String newAddress = scanner.nextLine();
                    teacherManager.editTeacher(editTeacherId, newName, newSubject, newAddress);
                    break;
                case 4:
                    System.out.print("Nhập mã giáo viên cần tìm: ");
                    String searchTeacherId = scanner.nextLine();
                    teacherView.displayTeacher(teacherManager.findTeacherById(searchTeacherId));
                    break;
                case 5:
                    System.out.print("Nhập mã giáo viên cần xóa: ");
                    String deleteTeacherId = scanner.nextLine();
                    teacherManager.deleteTeacher(deleteTeacherId);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        } while (teacherChoice != 0);
    }
}
