package org.example.controllers;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.example.dtos.account.RegisterDto;
import org.example.services.AccountService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/login")
    public String login() {
        return "account/login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("registerDto", new RegisterDto());
        return "account/register";
    }

    @PostMapping("/register")
    public String register(@Valid RegisterDto dto, BindingResult bindingResult, Model model, HttpServletRequest request) {
        if (dto.getPassword() != null && !dto.getPassword().equals(dto.getConfirmPassword())) {
            bindingResult.rejectValue("confirmPassword", "error.registerDto", "Паролі не збігаються");
        }
        if (bindingResult.hasErrors()) {
            model.addAttribute("registerDto", dto);
            return "account/register";
        }
        try {
            accountService.register(dto, request);
            return "redirect:/";
        }
        catch (Exception e) {
            model.addAttribute("registerDto", dto);
            model.addAttribute("error", e.getMessage());
            return "account/register";
        }
    }
}