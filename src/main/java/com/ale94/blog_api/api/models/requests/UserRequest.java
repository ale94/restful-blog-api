package com.ale94.blog_api.api.models.requests;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String urlProfile;
    private String username;
    private String password;


}
