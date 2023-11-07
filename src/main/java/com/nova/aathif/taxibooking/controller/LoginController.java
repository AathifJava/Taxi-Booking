package com.nova.aathif.taxibooking.controller;

import com.nova.aathif.taxibooking.dto.LoginDTO;
import com.nova.aathif.taxibooking.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    AdminService adminService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO){
        System.out.println(loginDTO.getEmail());
        System.out.println(loginDTO.getPassword());
        return adminService.login(loginDTO);
    }
}
