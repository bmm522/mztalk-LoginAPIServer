package com.mztalk.loginservice.user.service;

import com.mztalk.loginservice.domain.dto.request.ChangeNewNicknameRequestDto;
import com.mztalk.loginservice.domain.dto.request.ChangeNewPasswordReqeustDto;
import com.mztalk.loginservice.domain.dto.request.UpdatePasswordRequestDto;

public interface UpdateUserInfoService {
    int updatePassword(UpdatePasswordRequestDto updatePasswordRequestDto);

//    int updateMentorStatus(String nickname);

    int updateStatus(String nickname);

    int updateRoleChangeToVip(Long id);

    int updateRoleChangeToUser(Long id);

    int changeNewPassword(ChangeNewPasswordReqeustDto changeNewPasswordReqeustDto);

    int changeNewNickname(ChangeNewNicknameRequestDto changeNewNicknameRequestDto);

    int changeNewEmail(String userNo, String email);

    long updateUserStatus(String status, long id);
}
