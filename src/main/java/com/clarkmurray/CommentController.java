package com.clarkmurray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    @GetMapping("/comments")
    public List<Comment> index() {
        return commentRepository.findAll();
    }

    @GetMapping("/comments/{id}")
    public Comment show(@PathVariable Long id) {
        return commentRepository.findOne(id);
    }

    @PostMapping("/comments")
    public Comment create(@RequestBody Comment comment) {
        return commentRepository.save(comment);
    }

    @DeleteMapping("/comments/{id}")
    public boolean delete(@PathVariable Long id) {
        commentRepository.delete(id);
        return true;
    }
}
