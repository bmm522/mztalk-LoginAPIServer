package com.mztalk.loginservice.user.service.impl;

import com.mztalk.loginservice.domain.dto.response.CheckDuplicateResponseDto;
import com.mztalk.loginservice.user.repository.UserRepository;
import com.mztalk.loginservice.user.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckServiceImpl implements CheckService {

    @Autowired
    private UserRepository userRepository;

    public CheckDuplicateResponseDto checkUsername(String username) {
        return getResultMap(userRepository.existsByUsername(username));
    }

    public CheckDuplicateResponseDto checkNickname(String nickname){
        return getResultMap(userRepository.existsByNickname(nickname));
    }

    @Override
    public CheckDuplicateResponseDto checkEmail(String email) {
        return getResultMap(userRepository.existsByEmail(email));
    }

    private CheckDuplicateResponseDto getResultMap(boolean checkResult){

        if(!checkResult){

            return  new CheckDuplicateResponseDto("available");
        }

        return  new CheckDuplicateResponseDto("unavailable");
    }
}

