package com.mztalk.loginservice.user.service.impl;

import com.mztalk.loginservice.domain.dto.RegisterDto;
import com.mztalk.loginservice.user.repository.UserRepository;
import com.mztalk.loginservice.user.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void registerUser(RegisterDto registerDto) {
        userRepository.save(registerDto.toUserEntity(bCryptPasswordEncoder));
    }



}
