package org.skroshka.idp.repositories;

import org.skroshka.idp.entities.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Integer> {

}
