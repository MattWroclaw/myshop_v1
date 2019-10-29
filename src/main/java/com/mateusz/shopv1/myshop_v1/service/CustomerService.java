package com.mateusz.shopv1.myshop_v1.service;

import com.mateusz.shopv1.myshop_v1.repository.CustomerRepository;
import com.mateusz.shopv1.myshop_v1.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Collection<Customer> allCustomers(){
        return customerRepository.findAll();
    }

    public Customer findCustomer(Long id){
       return customerRepository.findById(id)
                .orElseThrow(
                        ()->new NoSuchElementException("No customer")
                );
    }

    public Customer editCustomer(Customer customer){
        Customer editedCustomer = customerRepository.findById(customer.getId())
                .orElseThrow( ()->new EntityNotFoundException("No such customer"));
        editedCustomer.setMail(customer.getMail());
        editedCustomer.setPassword(customer.getPassword());
        editedCustomer.setAdres(customer.getAdres());
        customerRepository.save(editedCustomer);
        return editedCustomer;
    }

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id){
        Customer deletedCustomer= customerRepository.findById(id)
                .orElseThrow( ()->new NoSuchElementException("No customer"));
         customerRepository.delete(deletedCustomer);
    }

}
