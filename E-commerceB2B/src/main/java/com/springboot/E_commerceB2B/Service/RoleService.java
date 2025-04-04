package com.springboot.E_commerceB2B.Service;

import com.springboot.E_commerceB2B.Entities.Role;
import com.springboot.E_commerceB2B.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoleService {

        @Autowired
        private RoleRepository roleRepository;

        public Role saveRole(Role role) {
            return roleRepository.save(role);
        }

        public Role getRoleById(UUID id) {
            return roleRepository.findById(id).orElse(null);
        }

        public List<Role> getAllRoles() {
            return roleRepository.findAll();
        }

        public void deleteRole(UUID id) {
            roleRepository.deleteById(id);
        }
}
