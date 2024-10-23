package com.ednach.customerservice.dto.responseCustomerDto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseCustomerDto {

    private String customerName;

    private String role;
}
