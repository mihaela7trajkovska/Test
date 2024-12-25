/*package mk.ukim.finki.lab_1.service.impl;

import mk.ukim.finki.lab_1.model.exceptions.InvalidArgumentsException;
import mk.ukim.finki.lab_1.model.exceptions.PasswordsDoNotMatchException;
import mk.ukim.finki.lab_1.model.exceptions.UsernameAlreadyExistsException;
import mk.ukim.finki.lab_1.repository.JPA.UserRepository;
import mk.ukim.finki.lab_1.service.AuthService;
import org.springframework.security.core.userdetails.User;

public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        // Check if the username and password are not null or empty
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        User user = userRepository.findByUsernameAndPassword(username, password)
                .orElseThrow(InvalidUserCredentialsException::new);
        return user;
    }


    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname) {
        // Check if the username, password, name and surname are not null or empty
        if (
                username == null ||
                        username.isEmpty() ||
                        password == null ||
                        password.isEmpty() ||
                        repeatPassword == null ||
                        repeatPassword.isEmpty() ||
                        name == null ||
                        name.isEmpty() ||
                        surname == null ||
                        surname.isEmpty()
        ) {
            throw new InvalidArgumentsException();
        }

        // Check if the password and the repeated password are the same
        if (!password.equals(repeatPassword)) {
            throw new PasswordsDoNotMatchException();
        }

        // Check if the username is already taken
        if (userRepository.findByUsername(username).isPresent()) {
            throw new UsernameAlreadyExistsException(username);
        }

        return userRepository.save(new User(username, password, name, surname));

    }
}
*/