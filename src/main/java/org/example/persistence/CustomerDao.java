package org.example.persistence;

import org.example.business.entities.Customer;

import java.util.List;

public interface CustomerDao {
    List<Customer> getAllCustomers();
}
