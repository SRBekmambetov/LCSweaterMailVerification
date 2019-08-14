package ru.srb.lcsweatermailverification.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.srb.lcsweatermailverification.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User findByActivationCode(String code);
}
