package com.developers.kameleoon.restapi.repositories;

import com.developers.kameleoon.restapi.models._User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<_User, Long> {
}
