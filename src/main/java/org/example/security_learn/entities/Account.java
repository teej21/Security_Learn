package org.example.security_learn.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.HashSet;

@Entity
@Table(name = "accounts")
@Data
@RequiredArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long acc_id;

    private String email;
    private String password;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private Customer customer;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private Employee employee;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private HashSet<Role> roles;


}
