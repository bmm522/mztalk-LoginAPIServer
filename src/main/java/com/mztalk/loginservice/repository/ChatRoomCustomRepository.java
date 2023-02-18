package com.mztalk.loginservice.repository;


import com.mztalk.loginservice.domain.entity.Chatroom;

import java.util.List;

public interface ChatRoomCustomRepository {


    List<Chatroom> getChatRoomListOfAuction(long userNo);

    List<Chatroom> getChatRoomListOfBung(long userNo);

    long deleteChatRoom(long fromUserNo, long toUserNo);

    long checkData(long fromUserId, long toUserId, String serviceName);

    List<Chatroom> getChatRoomListOfStroy(long userNo);
}
