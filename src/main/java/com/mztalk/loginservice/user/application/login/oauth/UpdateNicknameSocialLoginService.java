package com.mztalk.loginservice.user.application.login.oauth;

import com.mztalk.loginservice.domain.dto.request.FirstSocialRequestDto;
import com.mztalk.loginservice.domain.dto.response.JwtFirstSocialResponseDto;
import com.mztalk.loginservice.user.repository.entity.User;
import com.mztalk.loginservice.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

import static com.mztalk.loginservice.user.factory.JwtTokenFactory.getJwtTokenFactoryInstance;

@Service
@Transactional
@RequiredArgsConstructor
public class UpdateNicknameSocialLoginService {

    private final UserRepository userRepository;
    public JwtFirstSocialResponseDto setFirstLoginForSocialLoginUser(FirstSocialRequestDto firstSocialRequestDto) throws IOException {

        User preUser = userRepository.findByUsername(firstSocialRequestDto.getUsername());
        preUser.changeNickname(firstSocialRequestDto.getNewNickname());
        userRepository.commit();

        User newUser = userRepository.findByUsername(firstSocialRequestDto.getUsername());

        return new JwtFirstSocialResponseDto(getJwtTokenFactoryInstance().getJwtToken(newUser),String.valueOf(newUser.getId()),newUser.getNickname(),newUser.getRoleValue());




    }
}
