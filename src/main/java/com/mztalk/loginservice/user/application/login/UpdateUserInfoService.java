package com.mztalk.loginservice.user.application.login;

import com.mztalk.loginservice.domain.dto.request.ChangeNewNicknameRequestDto;
import com.mztalk.loginservice.user.api.dto.ClientChangeNewPasswordReqeustDto;
import com.mztalk.loginservice.user.application.login.dto.request.ServiceChangeNewPasswordRequestDto;
import com.mztalk.loginservice.user.application.login.dto.request.ServiceUpdatePasswordRequestDto;

public interface UpdateUserInfoService {
    int updatePassword(ServiceUpdatePasswordRequestDto dto);

//    int updateMentorStatus(String nickname);

    int updateStatus(String nickname);

    int updateRoleChangeToVip(Long id);

    int updateRoleChangeToUser(Long id);

    int changeNewPassword(ServiceChangeNewPasswordRequestDto dto);

    int changeNewNickname(ChangeNewNicknameRequestDto changeNewNicknameRequestDto);

    int changeNewEmail(String userNo, String email);

    long updateUserStatus(String status, long id);
}
