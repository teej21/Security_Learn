package org.example.security_learn.interfaces;

import lombok.Data;

import java.io.Serializable;

@Data
public class RoleId implements Serializable {
    private String role;
    private Long acc; // This is the primary key of the Account entity
}
