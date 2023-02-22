package com.mztalk.loginservice.user.application.login;

import com.mztalk.loginservice.domain.dto.response.EmailAuthResponseDto;

public interface MailService {
    EmailAuthResponseDto getAuthCodeOfEmail(String email);
}
