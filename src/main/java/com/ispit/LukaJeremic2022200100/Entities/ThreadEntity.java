package com.ispit.LukaJeremic2022200100.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "threads")
public class ThreadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "thread_id")
    private Long threadId;

    @Column(name = "thread_title", nullable = false)
    private String threadTitle;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @OneToMany(mappedBy = "thread", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CommentEntity> comments;

    // Constructors
    public ThreadEntity() {
    }

    public ThreadEntity(String threadTitle, String createdBy) {
        this.threadTitle = threadTitle;
        this.createdBy = createdBy;
    }

    public ThreadEntity(Long threadId, String threadTitle, LocalDateTime createdAt, String createdBy) {
        this.threadId = threadId;
        this.threadTitle = threadTitle;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
    }

    public Long getThreadId() {
        return threadId;
    }

    public String getThreadTitle() {
        return threadTitle;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public List<CommentEntity> getComments() {
        return comments;
    }
}
