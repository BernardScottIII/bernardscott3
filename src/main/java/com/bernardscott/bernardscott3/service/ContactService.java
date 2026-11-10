package com.bernardscott.bernardscott3.service;

import com.bernardscott.bernardscott3.model.ContactForm;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Service
public class ContactService {
    private final ObjectProvider<JavaMailSender> mailSenderProvider;
    private final RestClient restClient = RestClient.create();

    @Value("${contact.recipient:}")
    private String recipient;

    @Value("${contact.from:}")
    private String from;

    @Value("${contact.turnstile-secret:}")
    private String turnstileSecret;

    public ContactService(ObjectProvider<JavaMailSender> mailSenderProvider) {
        this.mailSenderProvider = mailSenderProvider;
    }

    public boolean isConfigured() {
        return !recipient.isBlank() && !from.isBlank() && !turnstileSecret.isBlank()
                && mailSenderProvider.getIfAvailable() != null;
    }

    public boolean sendIfVerified(ContactForm form, String remoteAddress) {
        if (!isConfigured() || form.getCaptchaToken() == null || form.getCaptchaToken().isBlank()) {
            return false;
        }

        try {
            MultiValueMap<String, String> verificationRequest = new LinkedMultiValueMap<>();
            verificationRequest.add("secret", turnstileSecret);
            verificationRequest.add("response", form.getCaptchaToken());
            verificationRequest.add("remoteip", remoteAddress);
            Map<?, ?> verification = restClient.post()
                    .uri("https://challenges.cloudflare.com/turnstile/v0/siteverify")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .body(verificationRequest)
                    .retrieve()
                    .body(Map.class);

            if (verification == null || !Boolean.TRUE.equals(verification.get("success"))) {
                return false;
            }
        } catch (RuntimeException exception) {
            return false;
        }

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom(from);
        mail.setTo(recipient);
        mail.setReplyTo(form.getEmail());
        mail.setSubject("Portfolio contact: " + form.getSubject().replaceAll("[\\r\\n]+", " "));
        mail.setText("From: " + form.getName() + " <" + form.getEmail() + ">\n\n" + form.getMessage());
        mailSenderProvider.getObject().send(mail);
        return true;
    }
}
