package com.mztalk.loginservice.user.service.impl;

import com.mztalk.loginservice.domain.dto.request.ChangeNewNicknameRequestDto;
import com.mztalk.loginservice.domain.dto.request.ChangeNewPasswordReqeustDto;
import com.mztalk.loginservice.domain.dto.request.UpdatePasswordRequestDto;
import com.mztalk.loginservice.exception.ChangeFailException;
import com.mztalk.loginservice.user.repository.UserRepository;
import com.mztalk.loginservice.user.service.UpdateUserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class UpdateUserInfoServiceImpl implements UpdateUserInfoService {
    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public int updatePassword(UpdatePasswordRequestDto updatePasswordRequestDto) {
       return userRepository.updatePassword(updatePasswordRequestDto.getUsername(), bCryptPasswordEncoder.encode(updatePasswordRequestDto.getPassword()));
    }

    @Override
    public int updateStatus(String nickname) {
        return userRepository.updateStatus(nickname);
    }

    @Override
    public int updateRoleChangeToVip(Long id) {
        return userRepository.updateRoleChangeToVip(id);
    }

    @Override
    public int updateRoleChangeToUser(Long id) {
        return userRepository.updateRoleChangeToUser(id);
    }

    @Override
    public int changeNewPassword(ChangeNewPasswordReqeustDto changeNewPasswordReqeustDto) {

        if(bCryptPasswordEncoder.matches(changeNewPasswordReqeustDto.getPrePassword(),userRepository.findByPasswordWithId(Long.parseLong(changeNewPasswordReqeustDto.getNewPassword())))){
            try {
                return userRepository.changedPassword(bCryptPasswordEncoder.encode(changeNewPasswordReqeustDto.getNewPassword()),Long.parseLong(changeNewPasswordReqeustDto.getId()));
            } catch (RuntimeException e){
                new ChangeFailException("기존 비밀번호 정보가 일치하지 않습니다.");
                return 0;
            }

        }
        return 0;
    }

    @Override
    public int changeNewNickname(ChangeNewNicknameRequestDto changeNewNicknameRequestDto) {
        return userRepository.updateNickname(Long.parseLong(changeNewNicknameRequestDto.getUserNo()),changeNewNicknameRequestDto.getNickname());
    }

    @Override
    public int changeNewEmail(String userNo, String email) {
        return userRepository.updateEmail(Long.parseLong(userNo), email);
    }

    @Override
    public long updateUserStatus(String status, long id) {
        return userRepository.updateUserStatus(status, id);
    }


}
