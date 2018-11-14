package adzarei.loe.webfirma.repository;

import adzarei.loe.webfirma.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);
}
