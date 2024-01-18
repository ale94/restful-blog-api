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
public class LikesRequest implements Serializable {

    private Long id;
    private String user_id;
    private String post_id;

}
