package Model;

public class ClassRoom {
    private String className;      // Tên lớp
    private String grade;          // Khối học
    private String teacher;        // Giáo viên chủ nhiệm
    private int studentCount;      // Số lượng học sinh

    public ClassRoom(String className, String grade, String teacher, int studentCount) {
        this.className = className;
        this.grade = grade;
        this.teacher = teacher;
        this.studentCount = studentCount;
    }

    // Getters và Setters
    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    public String getTeacher() { return teacher; }
    public void setTeacher(String teacher) { this.teacher = teacher; }

    public int getStudentCount() { return studentCount; }
    public void setStudentCount(int studentCount) { this.studentCount = studentCount; }

    @Override
    public String toString() {
        return className + "," + grade + "," + teacher + "," + studentCount;
    }
}
