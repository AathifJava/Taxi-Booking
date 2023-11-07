package com.nova.aathif.taxibooking.service.serviceImpl;

import com.nova.aathif.taxibooking.dto.LoginDTO;
import com.nova.aathif.taxibooking.model.AdminUser;
import com.nova.aathif.taxibooking.repository.AdminRepository;
import com.nova.aathif.taxibooking.service.AdminService;
import com.nova.aathif.taxibooking.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    JwtUtil jwtUtil;

    @Override
    public ResponseEntity<?> login(LoginDTO loginDTO) {
        Map<String, String> data = new HashMap<>();
        if (loginDTO.getEmail().equals("")) {
            data.put("data", "Username Not Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
        } else if (loginDTO.getPassword().equals("")) {
            data.put("data", "Password Not Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
        } else {
            AdminUser adminUser = adminRepository.findByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword());
            if (adminUser == null) {
                data.put("data", "Invalid Email or Password");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
            }

            String accessToken = jwtUtil.generateAccessToken(adminUser);
            data.put("data", "Successfully");
            data.put("accessToken", accessToken);

            return ResponseEntity.status(HttpStatus.OK).body(data);
        }
    }
}
