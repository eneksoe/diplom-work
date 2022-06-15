package com.bta.diplom.mapper;

import com.bta.diplom.dto.UserAccountDto;
import com.bta.diplom.model.UserAccount;
import org.springframework.stereotype.Component;

@Component
public class UserAccountWebMapper implements WebMapper<UserAccountDto, UserAccount> {

    @Override
    public UserAccountDto toDto(UserAccount entity) {
        return UserAccountDto.builder()
                .username(entity.getUsername())
                //.password(entity.getPassword())
                .email(entity.getEmail())
                .created(entity.getCreated())
                .build();
    }

    @Override
    public UserAccount toEntity(UserAccountDto dto) {
        return UserAccount.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .build();
    }
}
