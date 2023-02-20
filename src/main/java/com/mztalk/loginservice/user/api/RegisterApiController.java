package com.mztalk.loginservice.user.api;

import com.mztalk.loginservice.user.application.register.dto.response.ServiceCheckResponseDto;
import com.mztalk.loginservice.domain.dto.response.EmailAuthResponseDto;
import com.mztalk.loginservice.user.api.dto.ClientRegisterReqeustDto;
import com.mztalk.loginservice.user.api.mapper.ClientDtoToServiceDtoMapper;
import com.mztalk.loginservice.user.service.CheckService;
import com.mztalk.loginservice.user.service.MailService;
import com.mztalk.loginservice.user.application.register.RegisterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/login/register")
@RequiredArgsConstructor
@Api(tags = "register-api")
public class RegisterApiController {

    private final RegisterService registerService;
    private final CheckService checkService;
    private final MailService mailService;

    private final ClientDtoToServiceDtoMapper mapper = ClientDtoToServiceDtoMapper.getInstance();

    // 회원가입
    @PostMapping("/user")
    @ApiOperation(value = "회원가입", notes = "신규 회원가입을 합니다.")
    public void registerUser(@RequestBody @Valid ClientRegisterReqeustDto dto, BindingResult bindingResult){
        registerService.registerUser(mapper.toServiceDtoWhenRegister(dto));
    }

    // 아이디 중복검사
    @GetMapping("/username/{userId}")
    @ApiOperation(value = "아이디 중복검사" , notes = "기존의 아이디가 있는지 중복체크합니다.")
    public ServiceCheckResponseDto checkUsername(@PathVariable("userId")String username){
        return checkService.checkUsername(username);
    }

    // 닉네임 중복검사
    @GetMapping("/nickname/{nickname}")
    @ApiOperation(value = "닉네임 중복검사", notes = "기존의 닉네임이 있는지 중복체크합니다.")
    public ServiceCheckResponseDto checkNickname(@PathVariable("nickname")String nickname){
        return  checkService.checkNickname(nickname);
    }

    @GetMapping("/email/{email}")
    @ApiOperation(value = "이메일 중복검사" , notes = "기존의 이메일이 있는지 중복체크합니다.")
    public ServiceCheckResponseDto checkEmail(@PathVariable("email")String email){
        return checkService.checkEmail(email);
    }

    // 이메일 인증코드 전송
    @GetMapping("/auth-code/{email}")
    @ApiOperation(value = "이메일 코드", notes = "작성한 이메일로 랜덤 코드가 발송됩니다.")
    public EmailAuthResponseDto getAuthCodeOfEmail(@PathVariable("email")String email){
        return mailService.getAuthCodeOfEmail(email);
    }
}
