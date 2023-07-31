package com.cybersoft.cozastore_java21.repository;

import com.cybersoft.cozastore_java21.entity.SizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeRepository extends JpaRepository<SizeEntity,Integer> {
}
