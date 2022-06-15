package com.bta.diplom.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.ZonedDateTime;

import static javax.persistence.FetchType.EAGER;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "activation_link")
public class ActivationLink extends AbstractBaseEntity{

    @Size(max = 36)
    @NotEmpty
    private String code;

    private ZonedDateTime created;

    @OneToOne(fetch = EAGER)
    @JoinColumn(name = "user_account_id")
    private UserAccount userAccount;
}
