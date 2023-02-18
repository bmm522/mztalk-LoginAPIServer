package com.mztalk.loginservice.domain.dto;

import com.mztalk.loginservice.user.repository.entity.User;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {

    private String userId;
    private String password;
    private String nickname;
    private String email;

    public User toUserEntity(BCryptPasswordEncoder bCryptPasswordEncoder){
        return User.builder()
                .username(userId)
                .password(bCryptPasswordEncoder.encode(password))
                .nickname(nickname)
                .email(email)
                .role("ROLE_USER")
                .provider("LOCAL")
                .providerId("NULL")
                .status("Y")
                .reportCount(0L)
                .build();
    }

}
