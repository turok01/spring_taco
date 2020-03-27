package com.Igor.spring_taco.data;

import com.Igor.spring_taco.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

}
