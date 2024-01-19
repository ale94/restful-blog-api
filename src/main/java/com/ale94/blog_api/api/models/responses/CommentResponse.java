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
public class CommentResponse implements Serializable {

    private Long id;
    private String content;
    private LocalDateTime publishedAt;

}
