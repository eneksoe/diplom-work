package com.bta.diplom.security;

import com.bta.diplom.model.UserAccount;
import com.bta.diplom.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private UserAccountMapper userAccountMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final UserAccount userAccount = userAccountRepository.findByUsernameAndActive(username, true);
        if(userAccount == null){
            throw new UsernameNotFoundException("User with username " + username + " was not found in System!");
        }
        return userAccountMapper.toUserDetails(userAccount);
    }
}
