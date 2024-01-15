package com.ale94.blog_api;

import com.ale94.blog_api.domain.entities.CommentEntity;
import com.ale94.blog_api.domain.entities.PostEntity;
import com.ale94.blog_api.domain.entities.UserEntity;
import com.ale94.blog_api.domain.repositories.CommentRepository;
import com.ale94.blog_api.domain.repositories.PostRepository;
import com.ale94.blog_api.domain.repositories.UserRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
public class BlogApiApplication implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public static void main(String[] args) {
        SpringApplication.run(BlogApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        var user = UserEntity.builder()
            .firstName("Alejandro")
            .lastName("Rua")
            .registeredAt(LocalDateTime.now())
            .email("alejandrorua111@gmail.com")
            .mobile("3886523168")
            .urlProfile("www.perfil.com.ar")
            .username("ale94")
            .password("alejandro12")
            .build();

        var post = PostEntity.builder()
            .title("Mi primer post en un blog")
            .content("Estoy muy contento de realizar mi primera publicación en blogger")
            .createdAt(LocalDateTime.now())
            .published(true)
            .publishedAt(LocalDateTime.now())
            .updatedAt(null)
            .user(user)
            .build();

        var comment = CommentEntity.builder()
            .content("Mi primer comentario en una publicación de blog")
            .publishedAt(LocalDateTime.now())
            .post(post)
            .user(user)
            .build();

        userRepository.save(user);
        postRepository.save(post);
        commentRepository.save(comment);

        var userFromDB = userRepository.findById(1L).orElseThrow();
        var postFromDB = postRepository.findById(1L).orElseThrow();
        var commentFromDB = commentRepository.findById(1L).orElseThrow();

        log.info(String.valueOf(userFromDB));
        log.info(String.valueOf(postFromDB));
        log.info(String.valueOf(commentFromDB));
    }
}
