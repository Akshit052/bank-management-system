package com.teamb.bankmanagementsystem.service;

import com.teamb.bankmanagementsystem.exceptions.InvalidAmountException;
import com.teamb.bankmanagementsystem.model.Customer;
import com.teamb.bankmanagementsystem.repository.CustomerRepository;
import com.teamb.bankmanagementsystem.repository.DepositRepository;
import com.teamb.bankmanagementsystem.repository.WithdrawRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class WithdrawService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    TransactionService transactionService;
//    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    @Transactional
    public boolean withdrawMoney(String accountNumber,Double amount, String description) {
        boolean result = false;
        Customer currentUser = null;
        currentUser = customerRepository.findByAccountNumber(accountNumber);
//        if (authentication != null) {
//            if (authentication.getPrincipal() instanceof Customer) {
//                currentUser = (Customer) authentication.getPrincipal();
//                // Now you have access to the currentUser object
//            }
//        }
        if(currentUser==null){
            System.out.println("Customer not logged in !!!");
            return false;
        }
        try{
            if(amount>currentUser.getAccountBalance()){
                throw new InvalidAmountException("Not Sufficient Balance");
            }
            if(amount<0){
                throw new InvalidAmountException("Amount entered is not valid");
            }
            currentUser.setAccountBalance(currentUser.getAccountBalance()-amount);
            customerRepository.save(currentUser);
            result=true;
        }
        catch (InvalidAmountException e){
            System.out.println("Exception : "+ e.getMessage());
            return false;
        }
//        createTransaction(accountNumber, "Funds Added", amount, "-", description, "Credit");
        transactionService.createTransaction(currentUser,"Funds removed",amount,"SELF",description,"Debit");
        return result;
    }
}
