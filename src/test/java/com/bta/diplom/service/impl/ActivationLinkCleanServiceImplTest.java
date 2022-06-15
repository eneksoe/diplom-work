package com.bta.diplom.service.impl;

import com.bta.diplom.model.ActivationLink;
import com.bta.diplom.repository.ActivationLinkRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ActivationLinkCleanServiceImplTest {
    private ActivationLinkRepository activationLinkRepository;
    private ActivationLinkCleanServiceImpl instanceUnderTest;

    @BeforeEach
    void beforeEach(){
        activationLinkRepository = mock(ActivationLinkRepository.class);
        instanceUnderTest =  new ActivationLinkCleanServiceImpl(activationLinkRepository);
    }

    @Test
    public void testIfNoExpiredActivationLinks(){
        //given
        when(activationLinkRepository.findByCreatedBefore(any())).thenReturn(Collections.emptyList());

        //when
        instanceUnderTest.clean();

        //then
        verify(activationLinkRepository, never()).deleteAll(any());
    }

    @Test
    public void testIfExpiredActivationLinks(){
        when(activationLinkRepository.findByCreatedBefore(any()))
                .thenReturn(Collections.singletonList(
                        ActivationLink.builder().build()));

        instanceUnderTest.clean();

        verify(activationLinkRepository, times(1)).deleteAll(any());

    }

    @Test
    public void testIfExpiredActivationLinksAreNull(){
        when(activationLinkRepository.findByCreatedBefore(any()))
                .thenReturn(null);

        instanceUnderTest.clean();

        verify(activationLinkRepository, times(0)).deleteAll(any());

    }
}