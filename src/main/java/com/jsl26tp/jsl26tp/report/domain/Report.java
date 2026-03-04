package com.jsl26tp.jsl26tp.report.domain;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Report {
    private Long id;
    private Long reporterId;
    private String targetType;       // REVIEW, TOILET
    private Long targetId;
    private String reason;
    private String status;           // PENDING, RESOLVED, DISMISSED
    private String adminNote;
    private LocalDateTime createdAt;
    private LocalDateTime processedAt;

    // JOIN 용 추가 필드
    private String reporterNickname;
}
