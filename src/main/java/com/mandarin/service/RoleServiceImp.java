package com.mandarin.service;

import com.mandarin.dao.RoleRepository;
import com.mandarin.dao.RoleRepositoryImp;
import com.mandarin.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService {
    private final RoleRepository roleRepository;
    @Autowired
    public RoleServiceImp(RoleRepositoryImp roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional
    public List<Role> getAllRoles() {
        return roleRepository.getAllRoles();
    }

    @Transactional
    public List<Role> findByIdRoles(List<Long> id) {
        return roleRepository.findByIdRoles(id);
    }
}
