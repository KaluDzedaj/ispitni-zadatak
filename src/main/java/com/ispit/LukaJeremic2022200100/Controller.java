package com.ispit.LukaJeremic2022200100;

import com.ispit.LukaJeremic2022200100.Dtos.CommentDto;
import com.ispit.LukaJeremic2022200100.Dtos.ThreadDTO;
import com.ispit.LukaJeremic2022200100.Entities.CommentEntity;
import com.ispit.LukaJeremic2022200100.Entities.ThreadEntity;
import com.ispit.LukaJeremic2022200100.Repos.CommentRepo;
import com.ispit.LukaJeremic2022200100.Repos.ThreadRepo;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.MissingResourceException;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class Controller {

    @Autowired
    private ThreadRepo threadRepository;

    @Autowired
    private CommentRepo commentRepository;

    @GetMapping("/getThreads")
    public ResponseEntity<List<ThreadEntity>> getThreads(){
        return ResponseEntity.ok(threadRepository.findAll());
    }

    @GetMapping("/getSpecificThread/{threadId}")
    public Optional<ThreadEntity> getSpecificThread(@PathVariable Long threadId) {
        return threadRepository.findById(threadId);
    }

    @PostMapping("/createThread")
    public ResponseEntity<ThreadEntity> createThread(@RequestBody ThreadDTO threaddto) {
        ThreadEntity savedThread = threadRepository.save(new ThreadEntity(threaddto.getThread_title(), threaddto.getCreated_by()));
        System.out.println(savedThread);
        return ResponseEntity.ok(savedThread);
    }

    @PostMapping("/createComment")
    public ResponseEntity<CommentEntity> createComment(@RequestBody CommentDto commentDto) throws Exception {
        ThreadEntity threadEntity = threadRepository.findById(commentDto.getThread_id())
                .orElseThrow(() -> new Exception("Thread not found with id " + commentDto.getThread_id()));

        CommentEntity savedComment = commentRepository.save(new CommentEntity(commentDto.getCreated_by(), commentDto.getComment_text(), threadEntity));
        return ResponseEntity.ok(savedComment);
    }
}
