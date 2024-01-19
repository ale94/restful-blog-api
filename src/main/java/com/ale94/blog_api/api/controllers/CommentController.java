package com.ale94.blog_api.api.controllers;

import com.ale94.blog_api.api.models.requests.CommentRequest;
import com.ale94.blog_api.api.models.responses.CommentResponse;
import com.ale94.blog_api.infraestructure.abstract_services.ICommentService;
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
public class CommentController {

    private final ICommentService commentService;

    @PostMapping("/comment")
    public ResponseEntity<CommentResponse> post(@RequestBody CommentRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(commentService.create(request));
    }

    @GetMapping("/comment/{id}")
    public ResponseEntity<CommentResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(commentService.read(id));
    }

    @PutMapping("/comment/{id}")
    public ResponseEntity<CommentResponse> update(@RequestBody CommentRequest request,
        @PathVariable Long id) {
        return ResponseEntity.ok(commentService.update(request, id));
    }

    @DeleteMapping("/comment/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        commentService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
