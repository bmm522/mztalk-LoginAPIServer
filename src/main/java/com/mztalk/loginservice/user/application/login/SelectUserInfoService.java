package com.mztalk.loginservice.user.application.login;

import com.mztalk.loginservice.domain.dto.Result;
import com.mztalk.loginservice.user.application.login.dto.response.ServiceUserInfoResponseDto;
import com.mztalk.loginservice.domain.dto.response.SearchUsernameResponseDto;
import com.mztalk.loginservice.user.application.login.dto.response.ServiceUserInfoResponseDtos;

public interface SelectUserInfoService {
    SearchUsernameResponseDto searchUsername(String email);
    ServiceUserInfoResponseDto getUserInfoByNickname(String nickname);

    ServiceUserInfoResponseDto getUserInfoByUserNo(String userNo);

    ServiceUserInfoResponseDtos getMaliciousUser();
}
