package com.ednach.customerservice.comtroller;

import com.ednach.customerservice.dto.requestCustomerDto.RequestCustomerDto;
import com.ednach.customerservice.dto.responseCustomerDto.ResponseCustomerDto;
import com.ednach.customerservice.mapper.CustomerMapper;
import com.ednach.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerMapper mapper;

    @GetMapping
    public List<ResponseCustomerDto> getAllUsers() {
        return customerService.getAllUser().stream()
                .map(user -> mapper.getResponseUserDto(user)).collect(Collectors.toList());
    }

    @GetMapping("/{userId}")
    public ResponseCustomerDto getUserById(@PathVariable Integer userId) {
        return mapper.getResponseUserDto(customerService.getUserById(userId));
    }

    @PostMapping
    public ResponseCustomerDto createUser(@RequestBody RequestCustomerDto userDto) {
        return mapper.getResponseUserDto(customerService.saveNewUser(mapper.getUserEntity(userDto)));
    }

    @PutMapping("/{userId}")
    public ResponseCustomerDto updateUser(@PathVariable Integer userId, @RequestBody RequestCustomerDto userDto) {
        return mapper.getResponseUserDto(customerService.updateUser(userId, mapper.getUserEntity(userDto)));
    }

    @DeleteMapping("/{userId}")
    public void deleteUserById(@PathVariable Integer userId) {
        customerService.deleteUserById(userId);
    }
}
