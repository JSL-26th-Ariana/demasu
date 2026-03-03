package com.jsl26tp.jsl26tp.domain;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Inquiry {
    private Long id;
    private Long writerId;
    private Long adminId;
    private String title;
    private String content;
    private String status;           // WAITING, ANSWERED
    private String answer;
    private LocalDateTime answeredAt;
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;

    // JOIN 용 추가 필드
    private String writerNickname;
    private String adminNickname;
}
