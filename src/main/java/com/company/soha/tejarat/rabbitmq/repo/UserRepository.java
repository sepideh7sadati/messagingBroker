package com.company.soha.tejarat.rabbitmq.repo;

import com.company.soha.tejarat.rabbitmq.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
