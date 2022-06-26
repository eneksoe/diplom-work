package com.bta.diplom.service.impl;

import com.bta.diplom.model.ActivationLink;
import com.bta.diplom.repository.ActivationLinkRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ActivationLinkCleanServiceImplTest {
    @Mock
    private ActivationLinkRepository activationLinkRepository;

    @InjectMocks
    private ActivationLinkCleanServiceImpl instanceUnderTest;

    @Test
    public void testIfNoExpiredActivationLinks(){
        //given
        lenient().when(activationLinkRepository.findByCreatedBefore(any())).thenReturn(Collections.emptyList());

        //when
        instanceUnderTest.clean();

        //then
        verify(activationLinkRepository, never()).deleteAll(any());
    }

    @Test
    public void testIfExpiredActivationLinks(){
        lenient().when(activationLinkRepository.findByCreatedBefore(any()))
                .thenReturn(Collections.singletonList(
                        ActivationLink.builder().build()));

        instanceUnderTest.clean();

        verify(activationLinkRepository, times(1)).deleteAll(any());

    }

    @Test
    public void testIfExpiredActivationLinksAreNull(){
        lenient().when(activationLinkRepository.findByCreatedBefore(any()))
                .thenReturn(null);

        instanceUnderTest.clean();

        verify(activationLinkRepository, times(0)).deleteAll(any());

    }
}