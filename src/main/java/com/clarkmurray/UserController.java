package com.clarkmurray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> index() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public User show(@PathVariable String id) {
        Long userId = Long.parseLong(id);
        return userRepository.findOne(userId);
    }

    @PostMapping("/users/search")
    public List<User> search(@RequestBody Map<String, String> body) {
        String searchTerm = body.get("text");
        return userRepository.findByFirstNameContainingOrLastNameContaining(searchTerm, searchTerm);
    }

    @PostMapping("/users")
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/users/{id}")
    public User update(@PathVariable Long id, @RequestBody Map< String, String> body) {
        User update = userRepository.findOne(id);
        update.setId(id);
        update.setFirstName(body.get("firstName"));
        update.setLastName(body.get("lastName"));
        return userRepository.save(update);
    }

    @DeleteMapping("users/{id}")
    public boolean delete(@PathVariable Long id) {
        userRepository.delete(id);
        return true;
    }

}
