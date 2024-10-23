package com.ednach.customerservice.service;

import com.ednach.customerservice.model.Customer;
import com.ednach.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllUser() {
        return customerRepository.findAll();
    }

    public Customer getUserById(Integer userId) {
        return customerRepository.findById(userId).orElseThrow();
    }

    public Customer saveNewUser(Customer user) {
        return customerRepository.save(user);
    }

    public Customer updateUser(Integer id, Customer newCustomer) {
        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setCustomerName(newCustomer.getCustomerName());
                    customer.setEmail(newCustomer.getEmail());
                    customer.setRole(newCustomer.getRole());
                    return customerRepository.save(customer);
                }).orElseGet(() -> {
                    newCustomer.setId(id);
                    return customerRepository.save(newCustomer);
                });

    }

    public void deleteUserById(Integer userId) {
        customerRepository.deleteById(userId);
    }
}
