package com.jsl26tp.jsl26tp.domain;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class RecentView {
    private Long id;
    private Long userId;
    private Long toiletId;
    private LocalDateTime viewedAt;

    // JOIN 용 추가 필드
    private String toiletName;
    private String address;
}
