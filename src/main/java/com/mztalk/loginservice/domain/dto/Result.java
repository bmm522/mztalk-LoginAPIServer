package com.mztalk.loginservice.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Result<T> {

    private T data;

    public Result(T data){
        this.data = data;
    }
}
