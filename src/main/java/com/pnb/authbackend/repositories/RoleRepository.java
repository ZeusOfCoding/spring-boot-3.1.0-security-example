package com.pnb.authbackend.repositories;

import com.pnb.authbackend.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findRoleByAuthority(String authority);
}
