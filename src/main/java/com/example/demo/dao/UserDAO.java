package com.example.demo.dao;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.User;
//import com.example.demo.model.UserDynamo;


@EnableScan
public interface UserDAO extends CrudRepository <User, Integer>{

}
