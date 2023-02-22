package com.mztalk.loginservice.user.application.register.mapper;

import com.mztalk.loginservice.user.application.register.dto.reqeust.ServiceRegisterReqeustDto;
import com.mztalk.loginservice.user.repository.entity.User;

public class RegisterServiceDtoToEntityMapper {

    private static final RegisterServiceDtoToEntityMapper serviceDtoTiEntityMapper = new RegisterServiceDtoToEntityMapper();

    private RegisterServiceDtoToEntityMapper(){}

    public static RegisterServiceDtoToEntityMapper getInstance(){
        return serviceDtoTiEntityMapper;
    }

    public User toEntity(ServiceRegisterReqeustDto dto){
        return User.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .nickname(dto.getNickname())
                .email(dto.getEmail())
                .role(dto.getRole())
                .provider(dto.getProvider())
                .providerId(dto.getProviderId())
                .status(dto.getStatus())
                .reportCount(dto.getReportCount())
                .build();
    }
}
