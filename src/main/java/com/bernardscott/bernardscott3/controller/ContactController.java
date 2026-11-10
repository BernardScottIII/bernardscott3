package com.bernardscott.bernardscott3.controller;

import com.bernardscott.bernardscott3.model.ContactForm;
import com.bernardscott.bernardscott3.service.ContactService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.Instant;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class ContactController {
    private static final int MAX_SUBMISSIONS = 3;
    private static final long WINDOW_SECONDS = 600;
    private final ContactService contactService;
    private final ConcurrentHashMap<String, RateWindow> rateWindows = new ConcurrentHashMap<>();

    @Value("${contact.turnstile-site-key:}")
    private String turnstileSiteKey;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contact-me")
    public String contact(Model model) {
        if (!model.containsAttribute("contactForm")) {
            model.addAttribute("contactForm", new ContactForm());
        }
        model.addAttribute("turnstileSiteKey", turnstileSiteKey);
        model.addAttribute("contactConfigured", contactService.isConfigured() && !turnstileSiteKey.isBlank());
        return "contact-me";
    }

    @PostMapping("/contact-me")
    public String submit(@Valid @ModelAttribute("contactForm") ContactForm form,
                         BindingResult bindingResult,
                         @RequestParam(value = "cf-turnstile-response", required = false) String captchaToken,
                         HttpServletRequest request,
                         RedirectAttributes redirectAttributes,
                         Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("turnstileSiteKey", turnstileSiteKey);
            model.addAttribute("contactConfigured", contactService.isConfigured() && !turnstileSiteKey.isBlank());
            return "contact-me";
        }
        if (form.getWebsite() != null && !form.getWebsite().isBlank()) {
            redirectAttributes.addFlashAttribute("contactSuccess", true);
            return "redirect:/contact-me";
        }
        form.setCaptchaToken(captchaToken);

        String remoteAddress = request.getRemoteAddr();
        if (!withinRateLimit(remoteAddress)) {
            model.addAttribute("contactError", "Please wait a few minutes before trying again.");
        } else if (!contactService.sendIfVerified(form, remoteAddress)) {
            model.addAttribute("contactError", "Your message could not be verified or sent. Please try again later.");
        } else {
            redirectAttributes.addFlashAttribute("contactSuccess", true);
            return "redirect:/contact-me";
        }
        model.addAttribute("turnstileSiteKey", turnstileSiteKey);
        model.addAttribute("contactConfigured", contactService.isConfigured() && !turnstileSiteKey.isBlank());
        return "contact-me";
    }

    private boolean withinRateLimit(String address) {
        long now = Instant.now().getEpochSecond();
        RateWindow window = rateWindows.compute(address, (key, current) -> {
            if (current == null || now - current.startedAt >= WINDOW_SECONDS) {
                return new RateWindow(now, new AtomicInteger(1));
            }
            current.count.incrementAndGet();
            return current;
        });
        return window.count.get() <= MAX_SUBMISSIONS;
    }

    private record RateWindow(long startedAt, AtomicInteger count) { }
}
