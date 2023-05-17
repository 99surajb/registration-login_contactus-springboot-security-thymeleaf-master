package com.example.registrationlogindemo.repository;

import com.example.registrationlogindemo.entity.Contactus;
import com.example.registrationlogindemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactUsRepository extends JpaRepository<Contactus, Long> {
    Contactus findByEmail(String email);
}
