package model;

public class Student {
    private int studentId;
    private String name;
    private String email;
    private String department;
    private int userId;   // foreign key → User

    public Student() {}

    public Student(int studentId, String name, String email, String department, int userId) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.department = department;
        this.userId = userId;
    }

    // Getters & Setters
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
