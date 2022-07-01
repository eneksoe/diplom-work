package com.bta.diplom.security;

import com.bta.diplom.model.UserAccount;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserAccountMapper {

    public UserDetails toUserDetails(UserAccount userAccount){
        return  CustomUserDetails.builder()
                .username(userAccount.getUsername())
                .password(userAccount.getPassword())
                .accountNonLocked(userAccount.isActive())
                .credentialsNonExpired(true)
                .accountNonExpired(userAccount.isActive())
                .authorities(null)
                .enabled(userAccount.isActive())
                .build();
    }
}
