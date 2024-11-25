package Model;

public class Teacher {
    private String teacherId;     // Mã giáo viên
    private String name;          // Họ tên
    private String dob;           // Ngày sinh
    private String gender;        // Giới tính
    private String subject;       // Môn dạy
    private String address;       // Địa chỉ

    public Teacher(String teacherId, String name, String dob, String gender, String subject, String address) {
        this.teacherId = teacherId;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.subject = subject;
        this.address = address;
    }

    // Getters và Setters
    public String getTeacherId() { return teacherId; }
    public void setTeacherId(String teacherId) { this.teacherId = teacherId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    @Override
    public String toString() {
        return teacherId + "," + name + "," + dob + "," + gender + "," + subject + "," + address;
    }
}
