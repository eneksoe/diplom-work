package com.bta.diplom.service;

import com.bta.diplom.dto.UserAccountDto;
import org.springframework.stereotype.Service;

@Service
public interface UserAccountService {

    void create(UserAccountDto userAccount);

    void activate(String code);
}
