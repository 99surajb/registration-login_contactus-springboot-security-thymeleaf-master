package com.example.registrationlogindemo.controller;

import com.example.registrationlogindemo.dto.ContactUsDto;
import com.example.registrationlogindemo.dto.UserDto;
import com.example.registrationlogindemo.entity.Contactus;
import com.example.registrationlogindemo.entity.User;
import com.example.registrationlogindemo.service.ContactUsService;
import com.example.registrationlogindemo.service.UserService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AuthController {
       
	@Autowired
    private UserService userService;
	@Autowired
    private ContactUsService contactusservice;

    public AuthController(UserService userService, ContactUsService contactusservice) {
        this.userService = userService;
        this.contactusservice = contactusservice;
    }

    @GetMapping("index")
    public String home(){
        return "index";
    }
    @GetMapping("logout")
    public String home3(){
        return "logout";
    }
    @GetMapping("/login")
    public String loginForm() {
    return "redirect:/register?success";
    }

    // handler method to handle user registration request
    @GetMapping("register")
    public String showRegistrationForm(Model model){
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }
    @GetMapping("/contactus")
    public String showContactUsForm(Model model) {
    	ContactUsDto contactus  =	new ContactUsDto();
        model.addAttribute("contactus", contactus);
        return "contactus";
    }


    // handler method to handle register user form submit request
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto user,
                               BindingResult result,
                               Model model){
        User existing = userService.findByEmail(user.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/register?success";
    }

    @GetMapping("/users")
    public String listRegisteredUsers(Model model){
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }
    
	/*
	 * @GetMapping("/contactus") public String contactUsForm() { return "contactus";
	 * }
	 */
	/*
	 * @GetMapping("/contactus") public String home1(){ return "contactus";
	 */

   // }
    // handler method to handle register user form submit request
    @PostMapping("/contactus/save")
    public String registration(@Valid @ModelAttribute("contactus") ContactUsDto contactus,
                               BindingResult result,
                               Model model){
        Contactus existing = contactusservice.findByEmail(contactus.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (result.hasErrors()) {
            model.addAttribute("contactus", contactus);
            return "contactus";
        }
        contactusservice.saveUser(contactus);
        return "redirect:/contactus?success";
    }


}
