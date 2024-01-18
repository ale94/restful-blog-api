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
public class PostResponse implements Serializable {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private Boolean published;
    private LocalDateTime publishedAt;
    private LocalDateTime updatedAt;

}
