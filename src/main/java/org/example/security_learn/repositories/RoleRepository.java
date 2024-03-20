package org.example.security_learn.repositories;

import org.example.security_learn.entities.Role;
import org.example.security_learn.interfaces.RoleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, RoleId> {
}
