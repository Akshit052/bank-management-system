package com.teamb.bankmanagementsystem.controller;


import com.teamb.bankmanagementsystem.model.*;
import com.teamb.bankmanagementsystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class RegistrationController {

    @Autowired
    RegistrationService registrationService; // Inject your LoginService here

    @PostMapping("/register")
    public ResponseEntity<String> registerCustomer(@RequestBody CustomerDetails customerDTO) {
        boolean res = registrationService.createCustomer(customerDTO);
        if (res) {
            String message = "Welcome " + customerDTO.getFirstName() + " " + customerDTO.getLastName();
            System.out.println(message);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        else {
            System.out.println("customer not created");
            return new ResponseEntity<>("Customer not created", HttpStatus.BAD_REQUEST);
        }

//
    }


}


