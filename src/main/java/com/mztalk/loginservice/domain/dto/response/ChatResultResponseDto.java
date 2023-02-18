package com.mztalk.loginservice.domain.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChatResultResponseDto {

    private long result;

    public ChatResultResponseDto(long result){
        this.result = result;
    }

}
