package com.bta.diplom.service.impl;

import com.bta.diplom.dto.UserAccountDto;
import com.bta.diplom.email.EmailSenderImpl;
import com.bta.diplom.mapper.WebMapper;
import com.bta.diplom.model.ActivationLink;
import com.bta.diplom.model.UserAccount;
import com.bta.diplom.repository.ActivationLinkRepository;
import com.bta.diplom.repository.UserAccountRepository;
import com.bta.diplom.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.UUID;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    WebMapper<UserAccountDto, UserAccount> webMapper;

    @Autowired
    private ActivationLinkRepository activationLinkRepository;

    @Autowired
    private EmailSenderImpl emailSender;

    @Transactional
    @Override
    public void create(UserAccountDto userAccountDto) {
        checkIfUserAccountExist(userAccountDto);
        final UserAccount newUserAccount = webMapper.toEntity(userAccountDto);
        processNewUserAccount(newUserAccount);
        final UserAccount savedUserAccount = userAccountRepository.save(newUserAccount);
        final ActivationLink activationLink = createActivationLink(savedUserAccount);
        activationLinkRepository.save(activationLink);
        String link = "http://lockalhost:8081/user-account/activation?code=" + activationLink.getCode();
        emailSender.sendEmail(userAccountDto.getEmail(), link, "Please activate your Account in Diploma project");
    }

    @Transactional
    @Override
    public void activate(String code) {
        final var activationLink = activationLinkRepository.findByCode(code);
        checkActivationLink(activationLink, code);
        activationLink.getUserAccount().setActive(true);
        activationLinkRepository.delete(activationLink);
    }

    private void checkActivationLink(ActivationLink activationLink, String code) {
        if (activationLink == null) {
            throw new RuntimeException("Invalid code in activation link:" + code);
        }
        final Duration between = Duration.between(
                ZonedDateTime.now().toInstant(),
                activationLink.getCreated().toInstant());
        final long waitingPeriodInDays = between.toDays();
        if (waitingPeriodInDays >= 1) {
            throw new RuntimeException("Activation link with code: " + code + " already expired");
        }
    }

    private ActivationLink createActivationLink(UserAccount userAccount) {
        return ActivationLink.builder()
                .created(ZonedDateTime.now())
                .code(UUID.randomUUID().toString())
                .userAccount(userAccount)
                .build();
    }

    private void checkIfUserAccountExist(UserAccountDto userAccountDto) {
        final var userName = userAccountDto.getUsername();
        final var userAccountFromDb = userAccountRepository.findByUsernameAndActive(userName, false);
        if (userAccountFromDb != null) {
            throw new RuntimeException("User with username: " + userName + " already registered!");
        }
    }

    private void processNewUserAccount(UserAccount newUserAccount) {
        newUserAccount.setActive(false);
        newUserAccount.setCreated(ZonedDateTime.now());
    }
}
