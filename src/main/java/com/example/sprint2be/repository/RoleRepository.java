package com.example.sprint2be.repository;
import com.example.sprint2be.model.Role;
import com.example.sprint2be.model.constant.ERoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByRoleName(ERoleName roleName);

}
