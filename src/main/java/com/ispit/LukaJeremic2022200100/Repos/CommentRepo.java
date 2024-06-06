package com.ispit.LukaJeremic2022200100.Repos;

import com.ispit.LukaJeremic2022200100.Entities.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepo extends JpaRepository<CommentEntity, Long> {
}