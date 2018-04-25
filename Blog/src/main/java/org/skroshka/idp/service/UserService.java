package org.skroshka.idp.service;

import org.skroshka.idp.entities.User;

/**
 * Created by Serhii Kroshka on 25-April-18
 *
 */

public interface UserService {
	User findbyNickName(String nickName);

	User findbyEmail(String email);

	User saveUser(User user);

}
