package com.springboot.E_commerceB2B.Repository;

import com.springboot.E_commerceB2B.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository <Role, UUID> {
}
