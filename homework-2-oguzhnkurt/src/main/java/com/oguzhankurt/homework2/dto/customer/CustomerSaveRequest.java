package com.oguzhankurt.homework2.dto.customer;

import com.oguzhankurt.homework2.enums.EnumStatus;
import com.oguzhankurt.homework2.enums.EnumStatus;

public record CustomerSaveRequest(String name,
                                  String surname,
                                  String username,
                                  String email,
                                  String phone,
                                  EnumStatus type) {
}
