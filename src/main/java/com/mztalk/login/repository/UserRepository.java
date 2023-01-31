package com.mztalk.login.repository;

import com.mztalk.login.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long>, UserCustomRepository {
    User findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByNickname(String nickname);
    boolean existsByEmail(String email);
    User findByEmail(String email);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE User u set u.password = :password where u.username = :username")
    int updatePassword(@Param(value="username") String username,@Param(value="password") String password);



//    @Transactional
//    @Modifying(clearAutomatically = true)
//    @Query("UPDATE User u set u.mentorStatus = 'Y' where u.nickname = :nickname")
//    int updateMentorStatus(@Param(value = "nickname") String nickname);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE User u set u.status = 'N' where u.nickname = :nickname")
    int updateStatus(@Param(value="nickname")String nickname);

    User findByNickname(String nickname);



}
