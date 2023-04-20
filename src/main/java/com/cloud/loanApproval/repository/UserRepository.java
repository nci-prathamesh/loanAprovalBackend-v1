package com.cloud.loanApproval.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cloud.loanApproval.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUserIdAndPassword(String userid, String password);
	User findByUserId(String userId);
}
