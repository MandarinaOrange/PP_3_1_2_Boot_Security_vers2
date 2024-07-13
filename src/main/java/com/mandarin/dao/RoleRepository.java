package com.mandarin.dao;

import com.mandarin.model.Role;

import java.util.List;

public interface RoleRepository {
    public List<Role> getAllRoles();
    public List<Role> findByRoles(List<Long> id);
}
