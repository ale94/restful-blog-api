package com.ale94.blog_api.domain.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user")
@Entity
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    private String lastName;
    private LocalDateTime registeredAt;
    @Column(nullable = false)
    private String email;
    private String mobile;
    private String urlProfile;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;

    @OneToMany(
        fetch = FetchType.EAGER,
        orphanRemoval = true,
        cascade = CascadeType.ALL,
        mappedBy = "user"
    )
    List<PostEntity> posts;

    @OneToMany(
        fetch = FetchType.EAGER,
        orphanRemoval = true,
        cascade = CascadeType.ALL,
        mappedBy = "user"
    )
    List<CommentEntity> comments;

}
