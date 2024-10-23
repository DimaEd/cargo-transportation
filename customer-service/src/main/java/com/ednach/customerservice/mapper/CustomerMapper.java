package com.ednach.customerservice.mapper;

import com.ednach.customerservice.dto.requestCustomerDto.RequestCustomerDto;
import com.ednach.customerservice.dto.responseCustomerDto.ResponseCustomerDto;
import com.ednach.customerservice.model.Customer;
import com.ednach.userService.dto.requestCustomerDto.RequestCustomerDto;
import com.ednach.userService.dto.responseCustomerDto.ResponseCustomerDto;
import com.ednach.userService.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer getUserEntity(RequestCustomerDto customerDto) {
        return Customer.builder()
                .customerName(customerDto.getCustomerName())
                .email(customerDto.getEmail())
                .role(customerDto.getRole())
                .password(customerDto.getPassword())
                .build();
    }

    public ResponseCustomerDto getResponseUserDto(Customer customer) {
        return ResponseCustomerDto.builder()
                .customerName(customer.getCustomerName())
                .role(customer.getRole().name())
                .build();
    }


}
