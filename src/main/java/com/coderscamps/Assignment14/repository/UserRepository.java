package com.coderscamps.Assignment14.repository;

import com.coderscamps.Assignment14.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User,Long> {

}
