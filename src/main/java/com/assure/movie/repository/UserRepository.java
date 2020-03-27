package com.assure.movie.repository;

import com.assure.movie.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Israel Yasis
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
