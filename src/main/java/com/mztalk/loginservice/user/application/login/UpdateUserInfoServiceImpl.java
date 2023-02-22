package com.mztalk.loginservice.user.application.login;

import com.mztalk.loginservice.domain.dto.request.ChangeNewNicknameRequestDto;
import com.mztalk.loginservice.domain.dto.request.ChangeNewPasswordReqeustDto;
import com.mztalk.loginservice.global.exception.ChangeFailException;
import com.mztalk.loginservice.user.application.login.dto.request.ServiceUpdatePasswordRequestDto;
import com.mztalk.loginservice.user.repository.UserRepository;
import com.mztalk.loginservice.user.repository.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@Service
public class UpdateUserInfoServiceImpl implements UpdateUserInfoService {
    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public int updatePassword(ServiceUpdatePasswordRequestDto dto) {
       User user = getUserByUsername(dto.getUsername());
       String newPassword = bCryptPasswordEncoder.encode(dto.getPassword());
       user.updatePassword(newPassword);
       return 1;
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



    private User getUserByUsername(String username){
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByUsername(username))
                .orElseThrow(() -> new RuntimeException("Not Exists Username"));

        return userOptional.get();
    }
}
