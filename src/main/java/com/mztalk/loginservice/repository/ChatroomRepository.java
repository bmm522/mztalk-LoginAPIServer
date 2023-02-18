package com.mztalk.loginservice.repository;

import com.mztalk.loginservice.domain.entity.Chatroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatroomRepository extends JpaRepository<Chatroom, Long>, ChatRoomCustomRepository {
}
