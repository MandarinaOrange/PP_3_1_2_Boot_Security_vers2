package com.mandarin.service;


import com.mandarin.entity.Role;

import java.util.List;

public interface RoleService {
    public List<Role> getAllRoles();
    public List<Role> findByIdRoles(List<Long> id);
}
