package View;

import Model.ClassRoom;

import java.util.List;

public class ClassView {
    // Hiển thị danh sách lớp học
    public void displayClassRoomList(List<ClassRoom> classRooms) {
        for (ClassRoom classRoom : classRooms) {
            System.out.println(classRoom);
        }
    }

    // Hiển thị chi tiết lớp học
    public void displayClassRoom(ClassRoom classRoom) {
        if (classRoom != null) {
            System.out.println(classRoom);
        } else {
            System.out.println("Lớp học không tồn tại.");
        }
    }
}
