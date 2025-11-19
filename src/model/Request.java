package model;

import java.util.Date;

public class Request {
    private int requestId;
    private int studentId;     // foreign key → Student
    private String subject;
    private String description;
    private Date dateCreated;

    public Request() {}

    public Request(int requestId, int studentId, String subject, String description, Date dateCreated) {
        this.requestId = requestId;
        this.studentId = studentId;
        this.subject = subject;
        this.description = description;
        this.dateCreated = dateCreated;
    }

    // Getters & Setters
    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
