package com.mztalk.loginservice.user.service;

import com.mztalk.loginservice.domain.dto.response.JwtResponseDto;

public interface NewAccessTokenService {
    JwtResponseDto getNewAccessToken(String refreshToken);
}
