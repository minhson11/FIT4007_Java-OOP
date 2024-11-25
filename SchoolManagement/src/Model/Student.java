package Model;

public class Student {
    private String studentId;     // Mã học sinh
    private String name;          // Họ tên
    private String dob;           // Ngày sinh
    private String gender;        // Giới tính
    private String className;     // Lớp học
    private String address;       // Địa chỉ
    private double gpa;           // Điểm trung bình

    //constructor
    public Student(String studentId, String name, String dob, String gender, String className, String address, double gpa) {
        this.studentId = studentId;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.className = className;
        this.address = address;
        this.gpa = gpa;
    }

    // Getters và Setters
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public double getGpa() { return gpa; }
    public void setGpa(double gpa) { this.gpa = gpa; }

    @Override
    public String toString() {
        return studentId + "," + name + "," + dob + "," + gender + "," + className + "," + address + "," + gpa;
    }
}
