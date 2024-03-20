package org.example.security_learn.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import org.example.security_learn.interfaces.RoleId;

@Entity
@Table(name = "roles")
@IdClass(RoleId.class) // This is used to indicate a composite key class
@AllArgsConstructor
public class Role {

    @Id
    private String role;

    @Id
    @ManyToOne
    @JoinColumn(name = "acc_id", referencedColumnName = "acc_id")
    private Account account;


    public Role() {

    }
}

