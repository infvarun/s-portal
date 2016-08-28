package org.codepremier.studentportal.dao;

import java.util.Optional;

import org.codepremier.studentportal.model.User;

public interface UserDao {

	Optional<User> findByUserName(String username);

	User save(User user);
}
