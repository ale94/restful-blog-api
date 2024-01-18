package com.ale94.blog_api.api.controllers;

import com.ale94.blog_api.api.models.requests.PostRequest;
import com.ale94.blog_api.api.models.responses.PostResponse;
import com.ale94.blog_api.infraestructure.abstract_services.IPostService;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostController {

    private final IPostService postService;

    @PostMapping("/post")
    public ResponseEntity<PostResponse> post(@RequestBody PostRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(postService.create(request));
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<PostResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(postService.read(id));
    }

    @PutMapping("/post/{id}")
    public ResponseEntity<PostResponse> update(@RequestBody PostRequest request,
        @PathVariable Long id) {
        return ResponseEntity.ok(postService.update(request, id));
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        postService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
