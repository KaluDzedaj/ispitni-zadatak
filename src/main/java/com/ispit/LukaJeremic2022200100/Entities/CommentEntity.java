package com.ispit.LukaJeremic2022200100.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(name = "comment_text", nullable = false)
    private String commentText;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "thread_id", nullable = false)
    private ThreadEntity thread;

    // Constructors
    public CommentEntity() {
    }

    public CommentEntity(String createdBy, String commentText, ThreadEntity thread) {
        this.createdBy = createdBy;
        this.commentText = commentText;
        this.thread = thread;
    }

    public Long getCommentId() {
        return commentId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getCommentText() {
        return commentText;
    }

    public ThreadEntity getThread() {
        return thread;
    }
}

