package Controller;

import Model.Teacher;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherManagement {
    private List<Teacher> teacherList = new ArrayList<>();

    // Nhập danh sách giáo viên từ file .txt
    public void loadTeachersFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader("src\\data\\teachers.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 6) {
                    String teacherId = data[0];
                    String name = data[1];
                    String dob = data[2];
                    String gender = data[3];
                    String subject = data[4];
                    String address = data[5];
                    Teacher teacher = new Teacher(teacherId, name, dob, gender, subject, address);
                    teacherList.add(teacher);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Hiển thị danh sách giáo viên
    public List<Teacher> getAllTeachers() {
        return teacherList;
    }

    // Thêm giáo viên mới
    public void addTeacher(Teacher teacher) {
        teacherList.add(teacher);
    }

    // Sửa thông tin giáo viên
    public void editTeacher(String teacherId, String newName, String newSubject, String newAddress) {
        for (Teacher teacher : teacherList) {
            if (teacher.getTeacherId().equalsIgnoreCase(teacherId)) {
                teacher.setName(newName);
                teacher.setSubject(newSubject);
                teacher.setAddress(newAddress);
                break;
            }
        }
    }

    // Tìm kiếm giáo viên theo mã
    public Teacher findTeacherById(String teacherId) {
        for (Teacher teacher : teacherList) {
            if (teacher.getTeacherId().equalsIgnoreCase(teacherId)) {
                return teacher;
            }
        }
        return null;
    }

    // Xóa giáo viên
    public void deleteTeacher(String teacherId) {
        teacherList.removeIf(teacher -> teacher.getTeacherId().equalsIgnoreCase(teacherId));
    }

    // Tìm kiếm giáo viên theo môn
    public List<Teacher> findTeachersBySubject(String subject) {
        List<Teacher> result = new ArrayList<>();
        for (Teacher teacher : teacherList) {
            if (teacher.getSubject().equalsIgnoreCase(subject)) {
                result.add(teacher);
            }
        }
        return result;
    }
}
