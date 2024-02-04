package com.dash.navigation.repository;

import com.dash.navigation.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository.
 *
 * @author Jason.liu
 * @date 2024-02-04
 */
public interface UserRepository extends JpaRepository<User, String> {

}
