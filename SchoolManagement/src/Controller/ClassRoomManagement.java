package Controller;

import Model.ClassRoom;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClassRoomManagement {
    private List<ClassRoom> classRoomList = new ArrayList<>();

    // Nhập danh sách lớp học từ file
    public void loadClassRoomsFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader("src\\data\\classrooms.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    String className = data[0];
                    String grade = data[1];
                    String teacher = data[2];
                    int studentCount = Integer.parseInt(data[3]);
                    ClassRoom classRoom = new ClassRoom(className, grade, teacher, studentCount);
                    classRoomList.add(classRoom);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Hiển thị danh sách lớp học
    public List<ClassRoom> getAllClassRooms() {
        return classRoomList;
    }

    // Thêm lớp học mới
    public void addClassRoom(ClassRoom classRoom) {
        classRoomList.add(classRoom);
    }

    // Sửa thông tin lớp học
    public void editClassRoom(String className, String newTeacher, int newStudentCount) {
        for (ClassRoom classRoom : classRoomList) {
            if (classRoom.getClassName().equalsIgnoreCase(className)) {
                classRoom.setTeacher(newTeacher);
                classRoom.setStudentCount(newStudentCount);
                break;
            }
        }
    }

    // Tìm kiếm lớp học theo tên
    public ClassRoom findClassRoomByName(String className) {
        for (ClassRoom classRoom : classRoomList) {
            if (classRoom.getClassName().equalsIgnoreCase(className)) {
                return classRoom;
            }
        }
        return null;
    }

    // Xóa lớp học
    public void deleteClassRoom(String className) {
        classRoomList.removeIf(classRoom -> classRoom.getClassName().equalsIgnoreCase(className));
    }
}
