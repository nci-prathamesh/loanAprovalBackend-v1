package loan.approval.system.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import loan.approval.system.entity.LoanApplication;

public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long>  {

	List<LoanApplication> findByUserId(String userId);

	Optional<LoanApplication> findById(Long applicationId);
}
