package com.nova.aathif.taxibooking.repository;

import com.nova.aathif.taxibooking.model.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<AdminUser, Integer> {
    AdminUser findByEmailAndPassword(String email, String password);
}
