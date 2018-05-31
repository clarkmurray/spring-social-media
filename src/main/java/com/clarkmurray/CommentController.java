package com.clarkmurray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

//    @GetMapping("/comments")
//    public List<Comment> index() {
//        return commentRepository.findAll();
//    }

    @GetMapping("/posts/{postId}/comments")
    public List<Comment> getAllCommentsByPostId(@PathVariable (value="postId") Long postId) {
        return commentRepository.findByPostId(postId);
    }

//    @GetMapping("/comments/{id}")
//    public Comment show(@PathVariable Long id) {
//        return commentRepository.findOne(id);
//    }

    @PostMapping("/posts/{postId}/comments")
    public Comment createComment(@PathVariable (value="postId") Long postId, @RequestBody Comment comment) {
        comment.setPostId(postId);
        return commentRepository.save(comment);
    }

    @PutMapping("posts/{postId}/comments/{commentId}")
    public Comment updateComment(@PathVariable (value="postId") Long postId, @PathVariable (value="commentId") Long commentId, @RequestBody Map<String, String> body) {
        Comment comment = commentRepository.findOne(commentId);
        comment.setContent(body.get("content"));
        return commentRepository.save(comment);
    }

    @DeleteMapping("posts/{postId}/comments/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable (value="postId") Long postId, @PathVariable (value="commentId") Long commentId) {
        Comment comment = commentRepository.findOne(commentId);
        commentRepository.delete(comment);
        return ResponseEntity.ok().build();
    }

//    @PostMapping("/comments")
//    public Comment create(@RequestBody Comment comment) {
//        return commentRepository.save(comment);
//    }

}
