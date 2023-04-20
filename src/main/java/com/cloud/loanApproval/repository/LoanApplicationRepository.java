package com.cloud.loanApproval.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloud.loanApproval.model.LoanApplication;

public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long>  {

	List<LoanApplication> findByUserId(String userId);

	Optional<LoanApplication> findById(Long applicationId);
}
