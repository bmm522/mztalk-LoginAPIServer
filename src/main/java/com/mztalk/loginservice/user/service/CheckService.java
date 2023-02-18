package com.mztalk.loginservice.user.service;

import com.mztalk.loginservice.domain.dto.response.CheckDuplicateResponseDto;

public interface CheckService {
    CheckDuplicateResponseDto checkUsername(String username);

    CheckDuplicateResponseDto checkNickname(String nickname);

    CheckDuplicateResponseDto checkEmail(String email);
}
