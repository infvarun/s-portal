package org.codepremier.studentportal.serviceImpl;

import java.util.Optional;

import org.codepremier.studentportal.dao.UserDao;
import org.codepremier.studentportal.model.User;
import org.codepremier.studentportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao; 

	@Override
	public Optional<User> findByUserName(String username) {
		return userDao.findByUserName(username);
	}

	@Override
	public User save(User user) {
		return userDao.save(user);
	}
}
