package com.mztalk.loginservice.user.api.mapper;

import com.mztalk.loginservice.user.api.dto.ClientRegisterReqeustDto;
import com.mztalk.loginservice.user.application.register.dto.reqeust.ServiceRegisterReqeustDto;
import com.mztalk.loginservice.user.repository.entity.util.Provider;
import com.mztalk.loginservice.user.repository.entity.util.Role;

public class ClientDtoToServiceDtoMapper {

    private static final ClientDtoToServiceDtoMapper clientDtoToServiceDtoMapper = new ClientDtoToServiceDtoMapper();

    private ClientDtoToServiceDtoMapper(){}

    public static ClientDtoToServiceDtoMapper getInstance(){
        return clientDtoToServiceDtoMapper;
    }

    public ServiceRegisterReqeustDto toServiceDtoWhenRegister(ClientRegisterReqeustDto clientRegisterReqeustDto){
        return ServiceRegisterReqeustDto.builder()
                .username(clientRegisterReqeustDto.getUserId())
                .password(clientRegisterReqeustDto.getPassword())
                .nickname(clientRegisterReqeustDto.getNickname())
                .email(clientRegisterReqeustDto.getEmail())
                .role(Role.ROLE_USER)
                .provider(Provider.LOCAL)
                .providerId("NULL")
                .status("Y")
                .reportCount(0L)
                .build();
    }
}
