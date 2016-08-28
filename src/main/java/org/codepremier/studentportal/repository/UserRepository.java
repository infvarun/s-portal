package org.codepremier.studentportal.repository;

import java.util.Optional;

import org.codepremier.studentportal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByUserName(String username);

}
