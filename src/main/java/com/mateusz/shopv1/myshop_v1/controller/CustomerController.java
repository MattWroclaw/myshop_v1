package com.mateusz.shopv1.myshop_v1.controller;

import com.mateusz.shopv1.myshop_v1.dto.ErrorDto;
import com.mateusz.shopv1.myshop_v1.entity.Customer;
import com.mateusz.shopv1.myshop_v1.exception.EntityNotFoundException;
import com.mateusz.shopv1.myshop_v1.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public Collection<Customer> findAll(){
       return customerService.allCustomers();
    }

    @GetMapping("/{id}")
    public Customer findCustomer(@PathVariable Long id){
        return customerService.findCustomer(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }

    @PutMapping("/{id}")
    public Customer editCustomer(@RequestBody Customer customer,
                                 @PathVariable Long id){
        customer.setId(id);
        return customerService.editCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({EntityNotFoundException.class})
    public ErrorDto entityNotFoundExceptionHandler(EntityNotFoundException ex){
        ErrorDto error = new ErrorDto();
        error.setExceptionClass(ex.getClass().getCanonicalName());
        error.setMessage(ex.getMessage());
        return error;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Exception.class})
    public ErrorDto generalErorEcxeptionHanlder(Exception ex){
        ErrorDto error = new ErrorDto();
        error.setMessage(ex.getMessage());
        error.setExceptionClass(ex.getClass().getCanonicalName());
        return error;
    }

}
