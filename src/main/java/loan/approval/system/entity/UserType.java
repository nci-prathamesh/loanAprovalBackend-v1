package loan.approval.system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserType {
	
	@Id
	private int userId;
	private String userType;
	private String userFlag;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserFlag() {
		return userFlag;
	}
	public void setUserFlag(String userFlag) {
		this.userFlag = userFlag;
	}
}
