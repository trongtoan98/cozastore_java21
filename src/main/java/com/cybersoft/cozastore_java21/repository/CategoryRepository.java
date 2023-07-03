package com.cybersoft.cozastore_java21.repository;

import com.cybersoft.cozastore_java21.entity.CategoryEntity;
import com.cybersoft.cozastore_java21.payload.response.CategoryResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Integer> {
//    List<CategoryEntity> getAllCategory();

}
