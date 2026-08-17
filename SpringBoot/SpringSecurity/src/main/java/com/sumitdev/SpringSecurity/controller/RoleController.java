package com.sumitdev.SpringSecurity.controller;


import com.sumitdev.SpringSecurity.model.Role;
import com.sumitdev.SpringSecurity.services.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    private RoleService roleService;

    RoleController(RoleService roleService){
        this.roleService = roleService;
    }

    @PostMapping("/addRole")
    public ResponseEntity<String> addRole(@RequestBody Role role){
        String responseRole = roleService.addRole(role);

        return ResponseEntity.ok(responseRole);
    }

}
