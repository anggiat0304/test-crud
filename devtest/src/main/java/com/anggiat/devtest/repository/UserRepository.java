package com.anggiat.devtest.repository;

import com.anggiat.devtest.entity.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
        @Query(value = ("SELECT * FROM user_tbl WHERE token = :token") , nativeQuery = true)
        UserModel findUserByToken(String token);

        @Query(value = ("SELECT * FROM user_tbl WHERE phone = :phone"), nativeQuery = true)
        UserModel  findUserByPhone(String phone);


}
