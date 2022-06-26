package com.bta.diplom.service.impl;

import com.bta.diplom.model.ActivationLink;
import com.bta.diplom.model.UserAccount;
import com.bta.diplom.repository.ActivationLinkRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserAccountServiceImplTest {

    @InjectMocks
    private UserAccountServiceImpl instanceUnderTest = new UserAccountServiceImpl();

    @Mock
    private ActivationLinkRepository activationLinkRepository;

    @Test()
    public void testNullCode() {
        final String code = null;

        final RuntimeException actualResult = assertThrows(RuntimeException.class, () -> instanceUnderTest.activate(code));

        assertEquals("Activation code must be not null or Empty!", actualResult.getMessage());
    }

    @Test
    public void testEmptyCode() {
        final String code = "";

        final RuntimeException actualResult = assertThrows(RuntimeException.class, () -> instanceUnderTest.activate(code));

        assertEquals("Activation code must be not null or Empty!", actualResult.getMessage());
    }

    @Test
    public void TestNotNullInvalidCode() {
        final String code = "TEST_CODE";
        final ActivationLink activationLink = null;

        when(activationLinkRepository.findByCode(code))
                .thenReturn(activationLink);

        final RuntimeException actualResult = assertThrows(RuntimeException.class, () -> instanceUnderTest.activate(code));

        assertEquals("Invalid code in activation link:TEST_CODE", actualResult.getMessage());
    }

    @Test
    public void TestNotNullExpiredCode() {
        final String code = "TEST_CODE";
        final ActivationLink activationLink = ActivationLink.builder()
                .code("code")
                .created(ZonedDateTime.now().minusDays(1))
                .build();

        when(activationLinkRepository.findByCode(code))
                .thenReturn(activationLink);

        final RuntimeException actualResult = assertThrows(RuntimeException.class, () -> instanceUnderTest.activate(code));

        assertEquals("Activation link with code: TEST_CODE already expired", actualResult.getMessage());
    }

    @Test
    public void TestNotNullNotExpiredCode() {
        final String code = "TEST_CODE";

        final UserAccount userAccount = UserAccount.builder()
                .active(false)
                .build();

        final ActivationLink activationLink = ActivationLink.builder()
                .code("code")
                .created(ZonedDateTime.now())
                .userAccount(userAccount)
                .build();

        when(activationLinkRepository.findByCode(code))
                .thenReturn(activationLink);

        instanceUnderTest.activate(code);

        assertTrue(userAccount.isActive());
        assertEquals(true, activationLink.getUserAccount().isActive());

        verify(activationLinkRepository).delete(any());
        //Strict
        verify(activationLinkRepository, times(1)).delete(activationLink);
    }
}