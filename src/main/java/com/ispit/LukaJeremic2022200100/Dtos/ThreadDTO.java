package com.ispit.LukaJeremic2022200100.Dtos;

public class ThreadDTO {
    private String thread_title;
    private String created_by;

    public ThreadDTO(String thread_title, String created_by) {
        this.thread_title = thread_title;
        this.created_by = created_by;
    }

    public String getThread_title() {
        return thread_title;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setThread_title(String thread_title) {
        this.thread_title = thread_title;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }
}
