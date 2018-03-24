package org.skroshka.idp.repositories;

import org.skroshka.idp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{

}
