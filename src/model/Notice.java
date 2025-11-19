package model;

import java.util.Date;

public class Notice {
    private int noticeId;
    private String title;
    private String message;
    private Date dateCreated;

    public Notice() {}

    public Notice(int noticeId, String title, String message, Date dateCreated) {
        this.noticeId = noticeId;
        this.title = title;
        this.message = message;
        this.dateCreated = dateCreated;
    }

    // Getters & Setters
    public int getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
