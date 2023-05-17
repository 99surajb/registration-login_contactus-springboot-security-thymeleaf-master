package com.example.registrationlogindemo.service.impl;

import com.example.registrationlogindemo.dto.ContactUsDto;
import com.example.registrationlogindemo.dto.UserDto;
import com.example.registrationlogindemo.entity.Contactus;
import com.example.registrationlogindemo.entity.Role;
import com.example.registrationlogindemo.entity.User;
import com.example.registrationlogindemo.repository.ContactUsRepository;
import com.example.registrationlogindemo.repository.RoleRepository;
import com.example.registrationlogindemo.repository.UserRepository;
import com.example.registrationlogindemo.service.ContactUsService;
import com.example.registrationlogindemo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactUsServiceImpl implements ContactUsService {

	 private static final Contactus[] users = null;
	private ContactUsRepository contactusrepository;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public ContactUsServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder,
                           ContactUsRepository contactusrepository) {
    	  this.userRepository = userRepository;
          this.roleRepository = roleRepository;
          this.passwordEncoder = passwordEncoder;
           this.contactusrepository=contactusrepository;
       
    }

    @Override
    public void saveUser(ContactUsDto userDto) {
        Contactus user = new  Contactus();
        user.setName(userDto.getfirstName() + " " + userDto.getlastName());
      //  user.setName(userDto.getlastName() + " " + userDto.getlastName());
        user.setEmail(userDto.getEmail());
        user.setMessage(userDto.getMessage());

        //encrypt the password once we integrate spring security
        //user.setPassword(userDto.getPassword());
        //user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        //Role role = roleRepository.findByName("ROLE_ADMIN");
       // if(role == null){
         //   role = checkRoleExist();
      //  }
       // user.setRoles(Arrays.asList(role));
        contactusrepository.save(user);
    }

    @Override
    public Contactus findByEmail(String email) {
        return contactusrepository.findByEmail(email);
    }

    @Override
    public List<ContactUsDto> findAllUsers() {
    	List<ContactUsDto> userDtos = new ArrayList<>();
    	for (Contactus user : users) {
    	    ContactUsDto userDto = new ContactUsDto();
    	    userDto.setfirstName(user.getName());
    	    userDto.setlastName(user.getName());
    	    userDto.setEmail(user.getEmail());
    	    userDto.setMessage(user.getMessage());
    	    userDtos.add(userDto);
    	}
    	return userDtos;
    }

    private ContactUsDto convertEntityToDto(Contactus user){
        ContactUsDto userDto = new  ContactUsDto();
        String[] name = user.getName().split(" ");
        userDto.setfirstName(name[0]);
        userDto.setlastName(name[1]);
        userDto.setEmail(user.getEmail());
        return userDto;
    }

  

	
}
