package com.mztalk.loginservice.service;

import com.mztalk.loginservice.domain.dto.request.ChatOfUserNicknameRequestDto;
import com.mztalk.loginservice.domain.dto.request.ChatOfUserNoRequestDto;
import com.mztalk.loginservice.domain.dto.response.ChatResultResponseDto;

public interface InsertChatService {
    long requestChatOfUserNo(ChatOfUserNoRequestDto chatOfUserNoRequestDto);

    ChatResultResponseDto requestChatOfUserNickname(ChatOfUserNicknameRequestDto chatOfUserNicknameRequestDto);
}
