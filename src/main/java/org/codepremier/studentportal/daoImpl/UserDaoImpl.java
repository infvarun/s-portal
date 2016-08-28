package org.codepremier.studentportal.daoImpl;

import java.util.Optional;

import org.codepremier.studentportal.dao.UserDao;
import org.codepremier.studentportal.model.User;
import org.codepremier.studentportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDaoImpl implements UserDao{

	@Autowired
	private UserRepository userRepository;

	@Override
	public Optional<User> findByUserName(String username) {
		return userRepository.findByUserName(username);
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

}
