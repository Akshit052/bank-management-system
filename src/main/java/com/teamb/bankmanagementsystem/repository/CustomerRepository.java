package com.teamb.bankmanagementsystem.repository;

import com.teamb.bankmanagementsystem.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {
    Customer findByCustomerID(String customerID);
    Customer findByCustomerIDAndPassword(String customerId, String password);
    Customer findByAccountNumber(String accountNumber);
}
