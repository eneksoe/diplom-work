package com.bta.diplom.service.impl;

import com.bta.diplom.repository.ActivationLinkRepository;
import com.bta.diplom.service.ActivationLinkCleanService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.ZonedDateTime;

@Slf4j
@Service
public class ActivationLinkCleanServiceImpl implements ActivationLinkCleanService {

    @Autowired
    private ActivationLinkRepository activationLinkRepository;

   // @Scheduled(initialDelay = 2_000L, fixedRate = 10_000L)
    @Transactional
    @Override
    public void clean() {
        final var checkDate = ZonedDateTime.now().minusDays(1L);
        final var expiredLinks = activationLinkRepository.findByCreatedBefore(checkDate);
        if (expiredLinks == null || expiredLinks.isEmpty()) {
            log.info("No expired Activation Links in System!");
            return;
        }
        log.info("Detected " + expiredLinks.size() + " Activation Links in System!");
        activationLinkRepository.deleteAll(expiredLinks);
        log.info("Successfully cleaned up!");
    }
}
