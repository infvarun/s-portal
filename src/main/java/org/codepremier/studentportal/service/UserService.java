package org.codepremier.studentportal.service;

import java.util.Optional;

import org.codepremier.studentportal.model.User;

public interface UserService {

	Optional<User> findByUserName(String username);

	User save(User user);
}
