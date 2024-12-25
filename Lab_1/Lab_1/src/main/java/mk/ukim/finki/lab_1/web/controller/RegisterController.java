/*package mk.ukim.finki.lab_1.web.controller;

import mk.ukim.finki.lab_1.service.AuthService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class RegisterController {
    private final AuthService authService;

    public RegisterController(AuthService authService) {
        this.authService = authService;

    }

    @GetMapping
    public String getRegisterPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        return "register";
    }

    @PostMapping
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String repeatedPassword,
                           @RequestParam String name,
                           @RequestParam String surname

    ) {
        try {
            this.authService.register(username, password, repeatedPassword, name, surname);
            return "redirect:/login";
        } catch (RuntimeException ex) {
            // Redirect to the register page with an error message
            return "redirect:/register?error=" + ex.getMessage();
        }
    }


}
*/