package com.elkabani.mydb.repositories;

import com.elkabani.mydb.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
