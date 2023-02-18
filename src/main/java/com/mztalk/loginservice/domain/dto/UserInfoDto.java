package com.mztalk.loginservice.domain.dto;

import com.mztalk.loginservice.user.repository.entity.User;
import lombok.*;

import java.sql.Timestamp;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDto {


    private String userId;
    private String username;
    private String nickname;
    private String email;
    private String role;
    private String provider;
    private String providerId;
    private Timestamp createDate;
    private String status;
    private String reportCount;

    private String imageUrl;



    public UserInfoDto(User user){
        this.userId = String.valueOf(user.getId());
        this.username = user.getUsername();
        this.nickname = user.getNickname();
        this.email = user.getEmail();
        this.role = user.getRole();
        this.provider = user.getProvider();
        this.providerId = user.getProviderId();
        this.createDate = user.getCreateDate();
        this.status = user.getStatus();
        this.reportCount = String.valueOf(user.getReportCount());
    }
}
