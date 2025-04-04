package com.springboot.E_commerceB2B.Service;

import com.springboot.E_commerceB2B.Entities.Permission;
import com.springboot.E_commerceB2B.Repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PermissionService {

        @Autowired
        private PermissionRepository permissionRepository;

        public Permission savePermission(Permission permission) {
            return permissionRepository.save(permission);
        }

        public Permission getPermissionById(UUID id) {
            return permissionRepository.findById(id).orElse(null);
        }

        public List <Permission> getAllPermissions() {
            return permissionRepository.findAll();
        }

        public void deletePermission(UUID id) {
            permissionRepository.deleteById(id);
        }
}
