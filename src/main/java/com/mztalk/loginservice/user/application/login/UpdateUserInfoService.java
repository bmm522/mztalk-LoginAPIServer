package com.mztalk.loginservice.user.application.login;

import com.mztalk.loginservice.domain.dto.request.ChangeNewNicknameRequestDto;
import com.mztalk.loginservice.domain.dto.request.ChangeNewPasswordReqeustDto;
import com.mztalk.loginservice.user.api.dto.ClientUpdatePasswordRequestDto;
import com.mztalk.loginservice.user.application.login.dto.request.ServiceUpdatePasswordRequestDto;

public interface UpdateUserInfoService {
    int updatePassword(ServiceUpdatePasswordRequestDto dto);

//    int updateMentorStatus(String nickname);

    int updateStatus(String nickname);

    int updateRoleChangeToVip(Long id);

    int updateRoleChangeToUser(Long id);

    int changeNewPassword(ChangeNewPasswordReqeustDto changeNewPasswordReqeustDto);

    int changeNewNickname(ChangeNewNicknameRequestDto changeNewNicknameRequestDto);

    int changeNewEmail(String userNo, String email);

    long updateUserStatus(String status, long id);
}
