package com.daeuky.springboot.mybootapp.repositories;

import com.daeuky.springboot.mybootapp.entities.MyData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyDataRepository extends JpaRepository<MyData, Long>{
}
