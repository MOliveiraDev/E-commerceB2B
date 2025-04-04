package com.springboot.E_commerceB2B.Repository;

import com.springboot.E_commerceB2B.Entities.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PermissionRepository extends JpaRepository <Permission, UUID> {
}
