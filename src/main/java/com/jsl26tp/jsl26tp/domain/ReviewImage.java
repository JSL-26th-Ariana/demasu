package com.jsl26tp.jsl26tp.domain;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ReviewImage {
    private Long id;
    private Long reviewId;
    private String imageUrl;
    private LocalDateTime createdAt;
}
