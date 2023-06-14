package com.raunits.loggerdemo.repo;

import com.raunits.loggerdemo.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {
}
