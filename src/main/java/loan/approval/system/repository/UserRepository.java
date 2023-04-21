package loan.approval.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import loan.approval.system.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUserIdAndPassword(String userid, String password);
	User findByUserId(String userId);
}
