package com.teamb.bankmanagementsystem.controller;

import com.teamb.bankmanagementsystem.model.Customer;
import com.teamb.bankmanagementsystem.model.CustomerView;
import com.teamb.bankmanagementsystem.service.ViewBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class ViewBalanceController {
    @Autowired
    ViewBalanceService viewBalanceService;

    @GetMapping("/details")
    public ResponseEntity<CustomerView> viewCustomerDetails(@RequestParam("accountNumber") String accountNumber) {
        CustomerView customer = viewBalanceService.getCustomerDetails(accountNumber);
        if (customer != null) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            System.out.println("Account Number not found");
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
