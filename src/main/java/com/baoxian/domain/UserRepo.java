package com.baoxian.domain;

import com.baoxian.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

    User findByEmail(String email);
}
