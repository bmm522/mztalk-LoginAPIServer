package com.mztalk.loginservice.user.service.impl;

import com.mztalk.loginservice.domain.dto.response.EmailAuthResponseDto;
import com.mztalk.loginservice.user.repository.entity.User;
import com.mztalk.loginservice.user.repository.UserRepository;
import com.mztalk.loginservice.user.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailServiceByFindPwdService {

    private final MailService mailService;
    private final UserRepository userRepository;

    public EmailAuthResponseDto getEmailAuthCodeByFindPwd(String email, String username) {

        User user = userRepository.findByUsername(username);

        if(user.getEmail().equals(email)){
            return mailService.getAuthCodeOfEmail(email);
        }
        return new EmailAuthResponseDto( "Not Exists Username");
    }
}
