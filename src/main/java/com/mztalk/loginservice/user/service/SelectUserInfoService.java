package com.mztalk.loginservice.user.service;

import com.mztalk.loginservice.domain.dto.Result;
import com.mztalk.loginservice.domain.dto.UserInfoDto;
import com.mztalk.loginservice.domain.dto.response.SearchUsernameResponseDto;

public interface SelectUserInfoService {
    SearchUsernameResponseDto searchUsername(String email);
    UserInfoDto getUserInfoByNickname(String nickname);

    UserInfoDto getUserInfoByUserNo(String userNo);

    Result<?> getMaliciousUser();
}
