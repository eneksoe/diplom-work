package com.bta.diplom.email;

public interface EmailService {
    void sendEmail(String to, String body, String title);
}
