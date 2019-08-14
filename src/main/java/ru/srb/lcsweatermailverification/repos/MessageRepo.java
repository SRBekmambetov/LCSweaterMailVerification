package ru.srb.lcsweatermailverification.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.srb.lcsweatermailverification.domain.Message;

import java.util.List;

public interface MessageRepo extends JpaRepository<Message, Long> {

    List<Message> findByTag(String tag);

}
