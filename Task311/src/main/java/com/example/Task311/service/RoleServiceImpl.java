package com.example.Task311.service;

import com.example.Task311.DTO.RoleDTO;
import com.example.Task311.DTO.UserDTO;
import com.example.Task311.dao.RoleDao;
import com.example.Task311.model.Role;
import com.example.Task311.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void addRole(Role role) {
        roleDao.addRole(role);
    }

}
