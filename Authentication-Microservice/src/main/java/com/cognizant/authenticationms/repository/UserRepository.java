package com.cognizant.authenticationms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.authenticationms.model.Admin;

@Repository
public interface UserRepository extends JpaRepository<Admin, String> {

}