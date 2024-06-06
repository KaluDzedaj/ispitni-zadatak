package com.ispit.LukaJeremic2022200100.Repos;

import com.ispit.LukaJeremic2022200100.Entities.ThreadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThreadRepo extends JpaRepository<ThreadEntity, Long> {
}