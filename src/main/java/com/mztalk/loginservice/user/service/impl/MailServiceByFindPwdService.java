package com.mztalk.loginservice.user.service.impl;

import com.mztalk.loginservice.domain.dto.response.EmailAuthResponseDto;
import com.mztalk.loginservice.user.repository.entity.User;
import com.mztalk.loginservice.user.repository.UserRepository;
import com.mztalk.loginservice.user.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MailServiceByFindPwdService {

    private final MailService mailService;
    private final UserRepository userRepository;

    @Transactional(rollbackFor = RuntimeException.class)
    public EmailAuthResponseDto getEmailAuthCodeByFindPwd(String email, String username) {

        User user = userRepository.findByUsername(username);

        if(user.getEmail().equals(email)){
            return mailService.getAuthCodeOfEmail(email);
        }
        throw new RuntimeException("Not Exists Username");
    }
}
