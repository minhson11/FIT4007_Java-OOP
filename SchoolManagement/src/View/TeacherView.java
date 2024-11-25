package View;

import Model.Teacher;

import java.util.List;

public class TeacherView {
    // Hiển thị danh sách giáo viên
    public void displayTeacherList(List<Teacher> teachers) {
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }

    // Hiển thị chi tiết giáo viên
    public void displayTeacher(Teacher teacher) {
        if (teacher != null) {
            System.out.println(teacher);
        } else {
            System.out.println("Giáo viên không tồn tại.");
        }
    }
}
