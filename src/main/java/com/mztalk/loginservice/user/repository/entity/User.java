package com.mztalk.loginservice.user.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mztalk.loginservice.domain.cookie.MztalkCookie;
import com.mztalk.loginservice.domain.dto.UserInfoDto;
import com.mztalk.loginservice.domain.dto.response.JwtResponseDto;
import com.mztalk.loginservice.chat.repository.entity.Chatroom;
import com.mztalk.loginservice.domain.entity.Report;
import com.mztalk.loginservice.user.repository.entity.util.Provider;
import com.mztalk.loginservice.user.repository.entity.util.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private String nickname;
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private Provider provider;
    private String providerId;
    @CreationTimestamp
    private Timestamp createDate;
    private String status;

    private long reportCount;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Report> reports;

    @OneToMany(mappedBy = "fromUser")
    @JsonIgnore
    private List<Chatroom> fromUsers;

    public void changeNickname(String nickname){
        this.nickname = nickname;
    }

    public UserInfoDto toUserInfoDto(String imageUrl) {
        return UserInfoDto.builder()
                .userId(String.valueOf(id))
                .username(username)
                .nickname(nickname)
                .email(email)
                .role(role)
                .provider(provider)
                .providerId(providerId)
                .createDate(createDate)
                .status(status)
                .imageUrl(imageUrl)
                .reportCount(String.valueOf(reportCount))
                .build();
    }

    public UserInfoDto toUserInfoDto() {
        return UserInfoDto.builder()
                .userId(String.valueOf(id))
                .username(username)
                .nickname(nickname)
                .email(email)
                .role(role)
                .provider(provider)
                .providerId(providerId)
                .createDate(createDate)
                .status(status)
                .reportCount(String.valueOf(reportCount))
                .build();
    }

    public MztalkCookie getUsernameCookieFromMztalk() throws UnsupportedEncodingException {
        return new MztalkCookie(username);
    }

    public MztalkCookie toMztalkCookieWithExistsUser(JwtResponseDto jwtResponseDto) throws UnsupportedEncodingException {
        return new MztalkCookie(jwtResponseDto, id, nickname, status, role);
    }

    public String getRoleValue(){
        return this.role.getRole();
    }

}
