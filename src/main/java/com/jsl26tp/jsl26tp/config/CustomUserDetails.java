package com.jsl26tp.jsl26tp.config;

import com.jsl26tp.jsl26tp.auth.domain.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
public class CustomUserDetails implements UserDetails {

    private final Long id;
    private final String username;
    private final String password;
    private final String nickname;
    private final String email;
    private final String iconUrl;
    private final String status;        // ACTIVE, SUSPENDED, BANNED
    private final Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.nickname = user.getNickname();
        this.email = user.getEmail();
        this.iconUrl = user.getIconUrl();
        this.status = user.getStatus();
        this.authorities = List.of(new SimpleGrantedAuthority(user.getRole()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // BANNED 상태이면 계정 잠금
        return !"BANNED".equals(status);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        // ACTIVE 상태일 때만 로그인 허용
        return "ACTIVE".equals(status);
    }
}
