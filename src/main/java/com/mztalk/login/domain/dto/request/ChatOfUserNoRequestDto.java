package com.mztalk.login.domain.dto.request;


import com.mztalk.login.domain.entity.Chatroom;
import com.mztalk.login.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatOfUserNoRequestDto {

    private String serviceName;
    private long fromUserId;
    private long toUserId;

    public Chatroom toEntity(User fromUser) {
        return Chatroom.builder()
                .serviceName(serviceName)
                .fromUser(fromUser)
                .toUserNo(toUserId)
                .status("Y")
                .build();
    }
}
