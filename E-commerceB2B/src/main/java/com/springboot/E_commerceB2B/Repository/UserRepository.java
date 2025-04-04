package com.springboot.E_commerceB2B.Repository;

import com.springboot.E_commerceB2B.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository <User, UUID> {

}
