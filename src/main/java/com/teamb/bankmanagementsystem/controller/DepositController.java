package com.teamb.bankmanagementsystem.controller;

import com.teamb.bankmanagementsystem.service.DepositService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer/login")
public class DepositController {

    @Autowired
    private DepositService depositService;

    @PostMapping("/deposit")
    public ResponseEntity<String> depositFunds(@RequestParam("customerID") String customerID, @RequestParam("amount") Double amount, @RequestParam("description") String description) {

        boolean isSuccess = depositService.depositMoney(customerID,amount, description);

        if (isSuccess) {
            String message = "Amount Deposited Successfully";
            System.out.println(message);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            String message = "Failed to deposit the amount";
            System.out.println(message);
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
    }

}
