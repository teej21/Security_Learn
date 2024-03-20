package org.example.security_learn.controllers;

import org.example.security_learn.entities.Account;
import org.example.security_learn.entities.Customer;
import org.example.security_learn.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<?> registerCustomer(@RequestBody Account account, @RequestBody Customer customer) {
        try {
            customerService.registerNewCustomer(account, customer);
            return ResponseEntity.ok().body("Customer registered successfully");
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Login endpoint is not needed here as Spring Security handles it automatically based on your configurations
}
