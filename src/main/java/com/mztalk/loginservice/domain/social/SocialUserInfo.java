package com.mztalk.loginservice.domain.social;

import com.mztalk.loginservice.user.repository.entity.User;

public interface SocialUserInfo {

    String getProviderId();
    String getProvider();
    String getEmail();
    User toUserEntity();
}
