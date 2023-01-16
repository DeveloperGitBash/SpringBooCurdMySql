package com.myreddy.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myreddy.springboot.bean.User;

public interface MyRepository extends JpaRepository<User, Long>{

}
