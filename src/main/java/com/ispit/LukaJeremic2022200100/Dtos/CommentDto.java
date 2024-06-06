package com.ispit.LukaJeremic2022200100.Dtos;

public class CommentDto {
    private String created_by;
    private String comment_text;
    private Long thread_id;

    public CommentDto(String created_by, String comment_text, Long thread_id) {
        this.created_by = created_by;
        this.comment_text = comment_text;
        this.thread_id = thread_id;
    }

    public String getCreated_by() {
        return created_by;
    }

    public String getComment_text() {
        return comment_text;
    }

    public Long getThread_id() {
        return thread_id;
    }
}
