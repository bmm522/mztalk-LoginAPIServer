package com.mztalk.loginservice.user.service.impl;

import com.mztalk.loginservice.user.application.register.dto.response.ServiceCheckResponseDto;
import com.mztalk.loginservice.user.repository.UserRepository;
import com.mztalk.loginservice.user.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckServiceImpl implements CheckService {

    @Autowired
    private UserRepository userRepository;

    public ServiceCheckResponseDto checkUsername(String username) {
        return getResultMap(userRepository.existsByUsername(username));
    }

    public ServiceCheckResponseDto checkNickname(String nickname){
        return getResultMap(userRepository.existsByNickname(nickname));
    }

    @Override
    public ServiceCheckResponseDto checkEmail(String email) {
        return getResultMap(userRepository.existsByEmail(email));
    }

    private ServiceCheckResponseDto getResultMap(boolean checkResult){

        if(!checkResult){

            return  new ServiceCheckResponseDto("available");
        }

        return  new ServiceCheckResponseDto("unavailable");
    }
}

