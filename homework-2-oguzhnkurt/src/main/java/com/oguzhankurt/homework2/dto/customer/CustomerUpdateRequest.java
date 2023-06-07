package com.oguzhankurt.homework2.dto.customer;

import com.oguzhankurt.homework2.enums.EnumStatus;

public record CustomerUpdateRequest(String username,
                                    String email,
                                    String phone) {
}
