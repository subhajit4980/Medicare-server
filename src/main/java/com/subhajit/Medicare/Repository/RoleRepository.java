package com.subhajit.Medicare.Repository;

import com.subhajit.Medicare.Models.ERole;
import com.subhajit.Medicare.Models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}
