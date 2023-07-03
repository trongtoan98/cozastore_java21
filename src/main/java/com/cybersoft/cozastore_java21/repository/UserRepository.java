package com.cybersoft.cozastore_java21.repository;

import com.cybersoft.cozastore_java21.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
//    @Query("from users where email =?1")
//    List<UserEntity> getUserByEmail(String email);
    UserEntity findByEmail(String email);
}
