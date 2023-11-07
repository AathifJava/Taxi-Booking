package com.nova.aathif.taxibooking.service;

import com.nova.aathif.taxibooking.dto.LoginDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {
    ResponseEntity<?> login(LoginDTO loginDTO);
}
