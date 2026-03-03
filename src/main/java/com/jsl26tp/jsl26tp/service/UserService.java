package com.jsl26tp.jsl26tp.service;

import com.jsl26tp.jsl26tp.domain.User;
import com.jsl26tp.jsl26tp.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    // 회원가입
    public void register(User user) {
        // 비밀번호 BCrypt 암호화
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // 기본값 설정
        if (user.getRole() == null) {
            user.setRole("ROLE_USER");
        }
        if (user.getSocialType() == null) {
            user.setSocialType("LOCAL");
        }
        if (user.getIconUrl() == null || user.getIconUrl().isEmpty()) {
            user.setIconUrl("/img/default.png");
        }
        if (user.getStatus() == null) {
            user.setStatus("ACTIVE");
        }

        userMapper.insertUser(user);
    }

    // username 중복 체크
    public boolean isUsernameTaken(String username) {
        return userMapper.findByUsername(username) != null;
    }

    // 닉네임 중복 체크
    public boolean isNicknameTaken(String nickname) {
        return userMapper.findByNickname(nickname) != null;
    }

    // 이메일 중복 체크
    public boolean isEmailTaken(String email) {
        return userMapper.findByEmail(email) != null;
    }

    // 회원 정보 조회
    public User findById(Long id) {
        return userMapper.findById(id);
    }

    // 회원 정보 수정
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    // 비밀번호 변경
    public void updatePassword(Long id, String newPassword) {
        userMapper.updatePassword(id, passwordEncoder.encode(newPassword));
    }
}
