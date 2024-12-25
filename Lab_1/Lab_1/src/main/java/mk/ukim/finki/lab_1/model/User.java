package mk.ukim.finki.lab_1.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "users")
public class User  {

    @Id
    private String username;

    private String password;

    private String name;

    private String surname;




    public User(String username, String password, String name, String surname) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;

    }


}
