package com.jsl26tp.jsl26tp.controller;

import com.jsl26tp.jsl26tp.domain.User;
import com.jsl26tp.jsl26tp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    // 로그인 페이지 (모달 방식이므로 메인으로 리다이렉트, error/logout 파라미터 전달)
    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        Model model) {
        if (error != null) {
            model.addAttribute("loginError", true);
        }
        if (logout != null) {
            model.addAttribute("logoutSuccess", true);
        }
        return "index";
    }

    // 회원가입 페이지 (새 창으로 이동)
    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    // 회원가입 처리
    @PostMapping("/register")
    public String register(@ModelAttribute User user,
                           @RequestParam("passwordConfirm") String passwordConfirm,
                           RedirectAttributes redirectAttributes,
                           Model model) {

        // 비밀번호 확인 일치 여부
        if (!user.getPassword().equals(passwordConfirm)) {
            model.addAttribute("error", "パスワードが一致しません。");
            model.addAttribute("user", user);
            return "register";
        }

        // 비밀번호 8자 이상
        if (user.getPassword().length() < 8) {
            model.addAttribute("error", "パスワードは8文字以上で入力してください。");
            model.addAttribute("user", user);
            return "register";
        }

        // username 중복 체크
        if (userService.isUsernameTaken(user.getUsername())) {
            model.addAttribute("error", "すでに使用されているIDです。");
            model.addAttribute("user", user);
            return "register";
        }

        // 닉네임 중복 체크
        if (userService.isNicknameTaken(user.getNickname())) {
            model.addAttribute("error", "すでに使用されているニックネームです。");
            model.addAttribute("user", user);
            return "register";
        }

        // 이메일 중복 체크
        if (userService.isEmailTaken(user.getEmail())) {
            model.addAttribute("error", "すでに使用されているメールアドレスです。");
            model.addAttribute("user", user);
            return "register";
        }

        // 회원가입 실행
        userService.register(user);

        redirectAttributes.addFlashAttribute("registerSuccess", true);
        return "redirect:/login";
    }

    // username 중복 체크 API (Ajax용)
    @GetMapping("/api/check-username")
    @ResponseBody
    public boolean checkUsername(@RequestParam String username) {
        return !userService.isUsernameTaken(username);
    }

    // 닉네임 중복 체크 API (Ajax용)
    @GetMapping("/api/check-nickname")
    @ResponseBody
    public boolean checkNickname(@RequestParam String nickname) {
        return !userService.isNicknameTaken(nickname);
    }

    // 이메일 중복 체크 API (Ajax용)
    @GetMapping("/api/check-email")
    @ResponseBody
    public boolean checkEmail(@RequestParam String email) {
        return !userService.isEmailTaken(email);
    }
}
