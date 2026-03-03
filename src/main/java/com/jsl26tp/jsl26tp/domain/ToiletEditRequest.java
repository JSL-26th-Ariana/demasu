package com.jsl26tp.jsl26tp.domain;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ToiletEditRequest {
    private Long id;
    private Long toiletId;
    private Long userId;
    private String content;
    private String status;           // PENDING, APPROVED, REJECTED
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;

    // JOIN 용 추가 필드
    private String toiletName;
    private String nickname;
}
