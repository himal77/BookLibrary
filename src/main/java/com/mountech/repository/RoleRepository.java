package com.mountech.repository;

import com.mountech.domain.security.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository {
    Role findByName(String name);
}
