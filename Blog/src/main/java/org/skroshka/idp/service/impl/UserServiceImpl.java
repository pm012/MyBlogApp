package org.skroshka.idp.service.impl;

import org.skroshka.idp.entities.User;
import org.skroshka.idp.repositories.RoleRepository;
import org.skroshka.idp.repositories.UserRepository;
import org.skroshka.idp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by Serhii Kroshka on 25-April-18
 *
 */

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static final String USER_ROLE = "ROLE_USER";

	@Override
	public User findbyNickName(String nickName) {

		return userRepository.findByNickName(nickName);
	}

	@Override
	public User findbyEmail(String email) {

		return userRepository.findByEmail(email);
	}

	@Override
	public User saveUser(User user) {
		// user.setRoles(Arrays.asList(roleRepository.findByRole(USER_ROLE)));
		return userRepository.saveAndFlush(user);
	}

}
