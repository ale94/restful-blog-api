package com.ale94.blog_api.api.models.responses;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDateTime registeredAt;
    private String email;
    private String mobile;
    private String urlProfile;
}
