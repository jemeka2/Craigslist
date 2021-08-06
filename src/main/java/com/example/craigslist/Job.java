package com.example.craigslist;

import javax.validation.constraints.*;

public class Job {
    @NotNull
    @Min(1)
    private long id;

    private String role;

    @NotNull
    @NotEmpty
    private String title;

    @NotNull
    @NotEmpty
    @Size(min=5)
    private String description;

    @NotNull
    @NotEmpty
    private String postedDate;

    @NotNull
    @NotEmpty
    private String author;

    @NotNull
    @NotEmpty
    private String phoneNum;

    public Job() {
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getPostedDate() {
        return postedDate;
    }
    public void setPostedDate(String postedDate) {
        this.postedDate = postedDate;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPhoneNum() {
        return phoneNum;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        String num = String.valueOf(id);
        this.role = "USER1";
    }
}
