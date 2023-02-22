package com.mztalk.loginservice.user.application.login;

import com.mztalk.loginservice.domain.dto.request.ChangeNewNicknameRequestDto;
import com.mztalk.loginservice.user.api.dto.ClientChangeNewPasswordReqeustDto;
import com.mztalk.loginservice.global.exception.ChangeFailException;
import com.mztalk.loginservice.user.application.login.dto.request.ServiceChangeNewPasswordRequestDto;
import com.mztalk.loginservice.user.application.login.dto.request.ServiceUpdatePasswordRequestDto;
import com.mztalk.loginservice.user.repository.UserRepository;
import com.mztalk.loginservice.user.repository.entity.User;
import com.mztalk.loginservice.user.repository.entity.util.Role;
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
    @Transactional(rollbackFor = RuntimeException.class)
    public int updateStatus(String nickname) {
        User user = getUserByNickname(nickname);
        user.updateStatus("Y");
        return 1;
    }



    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public int updateRoleChangeToVip(Long id) {
        User user = getUserById(id);
        user.updateRole(Role.VIP);
        return 1;
    }

    @Override
    public int updateRoleChangeToUser(Long id) {
        User user = getUserById(id);
        user.updateRole(Role.ROLE_USER);
        return 1;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public int changeNewPassword(ServiceChangeNewPasswordRequestDto dto) {

        User user = getUserById(dto.getId());

        if(bCryptPasswordEncoder.matches(dto.getPrePassword(),userRepository.findByPasswordWithId(dto.getId()))){
            String newPassword = bCryptPasswordEncoder.encode(dto.getNewPassword());
            user.updatePassword(newPassword);
            return 1;
        }
        throw new RuntimeException("비밀번호가 일치하지 않습니다.");
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

    private User getUserByNickname(String nickname) {
        Optional<User> userOptional = Optional.of(userRepository.findByNickname(nickname))
                .orElseThrow(() -> new RuntimeException("닉네임에 해당하는 유저가 없습니다."));

        return userOptional.get();
    }

    private User getUserById(Long id) {
        Optional<User> userOptional = Optional.of(userRepository.findById(id))
                .orElseThrow(()-> new RuntimeException("번호에 해당하는 유저가 없습니다."));

        return userOptional.get();
    }
}
