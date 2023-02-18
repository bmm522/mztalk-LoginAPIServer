package com.mztalk.loginservice.user.api;

import com.mztalk.loginservice.domain.dto.request.FirstSocialRequestDto;
import com.mztalk.loginservice.domain.dto.response.JwtFirstSocialResponseDto;
import com.mztalk.loginservice.user.oauth.UpdateNicknameSocialLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;


@RequestMapping("/login/social")
@Controller
@RequiredArgsConstructor
@ApiIgnore
public class SocialController {


    private final UpdateNicknameSocialLoginService updateNicknameSocialLoginService;

    @GetMapping("/{social}")
    public String moveSocialLoginForm(@PathVariable("social") String social) throws IOException {
              return "redirect:/oauth2/authorization/"+social;
    }

    @ResponseBody
    @PatchMapping("/nickname")
    public JwtFirstSocialResponseDto setFirstLoginForSocialLoginUser(@RequestBody FirstSocialRequestDto firstSocialRequestDto) throws IOException {
        return updateNicknameSocialLoginService.setFirstLoginForSocialLoginUser(firstSocialRequestDto);
    }



}
