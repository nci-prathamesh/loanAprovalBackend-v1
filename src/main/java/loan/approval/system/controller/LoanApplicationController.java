package loan.approval.system.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import loan.approval.system.entity.LoanApplication;
import loan.approval.system.repository.LoanApplicationRepository;

@RestController
@RequestMapping(value = {"/loanapplication"})
@CrossOrigin(origins="http://localhost:3000")
public class LoanApplicationController {

	@Autowired
	private LoanApplicationRepository loanApplicationRepository;

	@PostMapping("/addloanapplication")
	LoanApplication newLoanApplication(@RequestBody LoanApplication newLoanApplication) {
		System.out.println("newLoanApplication : ");
		return loanApplicationRepository.save(newLoanApplication);
	}

	@GetMapping("/loanapplications")
	List<LoanApplication> getAllUsers() {
		return loanApplicationRepository.findAll();

	}
	
	@GetMapping("/loanapplication/{applicationId}")
	Optional<LoanApplication> getLoanApplicationByApplicationId(@PathVariable Long applicationId) {
		System.out.println(applicationId);
//		 System.out.println( "eeeeeeeee  "+userRepository.findByUserId(userid).getUserId());
		 return loanApplicationRepository.findById(applicationId);
	}
	
	@GetMapping("/loanapplications/{userId}")
	List<LoanApplication> getLoanApplicationByUserId(@PathVariable String userId) {
		System.out.println("userId : " +userId);
//		 System.out.println( "eeeeeeeee  "+userRepository.findByUserId(userid).getUserId());
		 return loanApplicationRepository.findByUserId(userId);
	}
	
	@PutMapping("/update/{applicationId}")
	LoanApplication updateStatus(@RequestBody LoanApplication newLoanApplication, @PathVariable Long applicationId) {
		loanApplicationRepository.findById(applicationId).get().setStatus(newLoanApplication.getStatus());
		return loanApplicationRepository.save(newLoanApplication);
	}
}
