package com.example.registrationlogindemo.service;

import com.example.registrationlogindemo.dto.ContactUsDto;
import com.example.registrationlogindemo.dto.UserDto;
import com.example.registrationlogindemo.entity.Contactus;
import com.example.registrationlogindemo.entity.User;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public interface ContactUsService {
    void saveUser(ContactUsDto userDto);

    Contactus findByEmail(String email);

    List<ContactUsDto> findAllUsers();
}
