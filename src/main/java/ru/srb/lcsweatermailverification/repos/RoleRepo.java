package ru.srb.lcsweatermailverification.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.srb.lcsweatermailverification.domain.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
