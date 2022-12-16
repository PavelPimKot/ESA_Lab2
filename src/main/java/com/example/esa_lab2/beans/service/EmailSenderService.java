package com.example.esa_lab2.beans.service;

public interface EmailSenderService {
    void sendSimpleEmail(String toEmail, String subject, String body);
}
