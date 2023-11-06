package com.teamb.bankmanagementsystem.repository;

import com.teamb.bankmanagementsystem.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import java.text.SimpleDateFormat;

public interface LoginRepository extends JpaRepository<Customer, String> {

    Customer findByCustomerIDAndPassword(String customerId, String password);
}
