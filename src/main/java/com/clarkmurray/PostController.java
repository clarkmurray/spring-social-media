package com.clarkmurray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class PostController {

    @Autowired
    PostRepository postRepository;

    @GetMapping("/posts")
    public List<Post> index() {
        return postRepository.findAll();
    }

    @GetMapping("/posts/{id}")
    public Post show(@PathVariable Long id) {
        return postRepository.findOne(id);
    }

    @PostMapping("/posts/search")
    public List<Post> search(@RequestBody Map<String, String> body) {
        String searchTerm = body.get("text");
        return postRepository.findByContentContaining(searchTerm);
    }

    @PostMapping("/posts")
    public Post create(@RequestBody Post post) {
        return postRepository.save(post);
    }

    @PutMapping("/posts/{id}")
    public Post update(@PathVariable Long id, @RequestBody Map<String, String> body) {
        Post update = postRepository.findOne(id);
        update.setId(id);
        update.setContent(body.get("content"));

        return postRepository.save(update);
    }

    @DeleteMapping("/posts/{id}")
    public boolean delete(@PathVariable Long id) {
        postRepository.delete(id);
        return true;
    }

}
