package com.sumitdev.SpringSecurity.services;

import com.sumitdev.SpringSecurity.model.Role;
import com.sumitdev.SpringSecurity.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {


    private RoleRepository roleRepository;

    RoleService(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    public String addRole(Role role){
        roleRepository.save(role);
        return  " ";
    }


}
