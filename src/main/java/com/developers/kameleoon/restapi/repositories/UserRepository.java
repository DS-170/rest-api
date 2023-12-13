package com.developers.kameleoon.restapi.repositories;

import com.developers.kameleoon.restapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
