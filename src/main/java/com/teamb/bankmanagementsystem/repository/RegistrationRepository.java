package com.teamb.bankmanagementsystem.repository;

import com.teamb.bankmanagementsystem.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Customer, String> {

}
