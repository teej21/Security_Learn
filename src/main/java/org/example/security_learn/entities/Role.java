package org.example.security_learn.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import org.example.security_learn.interfaces.RoleId;

import java.io.Serializable;

@Entity
@Table(name = "roles")
@IdClass(RoleId.class)
public class Role implements Serializable {
    @Id
    private String name;
    @Id
    private Long acc_id; // Add this missing property
    @OneToOne
    @JoinColumn(name = "acc_id", referencedColumnName = "acc_id", insertable = false, updatable = false)
    private Account account;
}


