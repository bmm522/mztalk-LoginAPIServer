package com.mztalk.loginservice.user.service;

import com.mztalk.loginservice.domain.dto.response.EmailAuthResponseDto;

public interface MailService {
    EmailAuthResponseDto getAuthCodeOfEmail(String email);
}
