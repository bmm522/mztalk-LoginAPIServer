package com.mztalk.loginservice.service;

import com.mztalk.loginservice.domain.dto.Result;

public interface SelectChatService {
    Result<?> getChatRoomListOfAuction(long userNo);

    Result<?> getChatRoomListOfBung(long userNo);

    Result<?> getChatRoomListOfStroy(long userNo);
}
