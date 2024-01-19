package com.ale94.blog_api.api.exceptions;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorDTO {

    private LocalDateTime time;
    private String message;
    private String url;

    public ErrorDTO(String message, String url) {
        this.time = LocalDateTime.now();
        this.message = message;
        this.url = url.replace("uri=", "");
    }
}
