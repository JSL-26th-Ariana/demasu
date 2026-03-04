package com.jsl26tp.jsl26tp.auth.mapper;

import com.jsl26tp.jsl26tp.auth.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface UserMapper {

    // 회원가입
    void insertUser(User user);

    // 로그인용 - username으로 회원 조회
    User findByUsername(@Param("username") String username);

    // 이메일로 회원 조회
    User findByEmail(@Param("email") String email);

    // 닉네임으로 회원 조회 (중복 체크용)
    User findByNickname(@Param("nickname") String nickname);

    // 소셜 로그인 - socialType + socialId로 조회
    User findBySocial(@Param("socialType") String socialType, @Param("socialId") String socialId);

    // 회원 정보 수정
    void updateUser(User user);

    // 비밀번호 변경
    void updatePassword(@Param("id") Long id, @Param("password") String password);

    // 회원 상태 변경 (관리자: 정지/차단)
    void updateStatus(@Param("id") Long id, @Param("status") String status, @Param("suspendUntil") String suspendUntil);

    // 회원 목록 (관리자용)
    List<User> findAllUsers();

    // 회원 ID로 조회
    User findById(@Param("id") Long id);
}
