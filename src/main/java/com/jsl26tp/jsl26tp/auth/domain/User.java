package com.jsl26tp.jsl26tp.auth.domain;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String phone;
    private String gender;
    private LocalDate birthdate;
    private String iconUrl;
    private String role;            // ROLE_USER, ROLE_ADMIN
    private String socialType;      // LOCAL, GOOGLE
    private String socialId;
    private Integer lineAgreed;     // LINE 챗봇 동의 여부 (0 or 1)
    private String status;          // ACTIVE, SUSPENDED, BANNED
    private LocalDateTime suspendUntil;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
