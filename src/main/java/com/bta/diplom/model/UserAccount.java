package com.bta.diplom.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.ZonedDateTime;

import static javax.persistence.FetchType.LAZY;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "user_account")
public class UserAccount extends AbstractBaseEntity {
    private String username;
    private String password;
    private boolean active;
    private ZonedDateTime created;
    private String email;

    @OneToOne(mappedBy = "userAccount", fetch = LAZY)
    private ActivationLink activationLink;
}
