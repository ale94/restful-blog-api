package com.ale94.blog_api.api.controllers;

import com.ale94.blog_api.api.models.requests.UserRequest;
import com.ale94.blog_api.api.models.responses.CommentResponse;
import com.ale94.blog_api.api.models.responses.PostResponse;
import com.ale94.blog_api.api.models.responses.UserResponse;
import com.ale94.blog_api.infraestructure.abstract_services.IUserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserResponse> post(@RequestBody UserRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(userService.create(request));
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(userService.read(id));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserResponse> update(@RequestBody UserRequest request,
        @PathVariable Long id) {
        return ResponseEntity.ok(userService.update(request, id));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/posts/users/{id}")
    public List<PostResponse> getPostsByUserId(@PathVariable Long id) {
        return userService.findPostsByUserId(id);
    }

    @GetMapping("/posts/users")
    public List<PostResponse> getPostsByUsername(@RequestParam String username) {
        return userService.findPostsByUsername(username);
    }

    @GetMapping("/comment/users/{id}")
    public List<CommentResponse> getCommentsByUserId(@PathVariable Long id) {
        return userService.findCommentsByUserId(id);
    }

    @GetMapping("/comment/users")
    public List<CommentResponse> getCommentsByUsername(@RequestParam String username) {
        return userService.findCommentsByUsername(username);
    }

}
