package com.mztalk.loginservice.user.api.mapper;

import com.mztalk.loginservice.user.api.dto.response.ClientResponseDto;
import org.springframework.web.bind.annotation.RestControllerAdvice;

public class ServiceDtoToControllerDtoMapper {

    private static final ServiceDtoToControllerDtoMapper serviceDtoToControllerDtoMapper= new ServiceDtoToControllerDtoMapper();

    private ServiceDtoToControllerDtoMapper(){}

    public static ServiceDtoToControllerDtoMapper getInstance(){
        return serviceDtoToControllerDtoMapper;
    }

    public ClientResponseDto success(String msg, Object body){
        return ClientResponseDto.builder()
                .code(1)
                .msg(msg)
                .body(body)
                .build();
    }

}
