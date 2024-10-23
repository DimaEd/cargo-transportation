package com.ednach.customerservice.dto.requestCustomerDto;

import com.ednach.customerservice.model.RoleEnum;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestCustomerDto {

    private String customerName;

    private String email;

    private RoleEnum role;

    private String password;
}
