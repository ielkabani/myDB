package com.elkabani.mydb.repositories;

import com.elkabani.mydb.entities.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}