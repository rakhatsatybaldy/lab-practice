package kenn.shi.labpractice.repository.user;

import kenn.shi.labpractice.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User , Long> {
    boolean existsByEmail(String email);
    User getById(Long id);
}
