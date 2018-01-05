package yike.dto;

import io.swagger.annotations.ApiModelProperty;

public class AccountUpdateDTO {
	
	private Long id;

	@ApiModelProperty("用户名")
	private String username;
	
	@ApiModelProperty("手机号")
	private String mobile;
	
	@ApiModelProperty("邮箱")
	private String email;
	
	private String inviteCode;
	
	private String apnsToken;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInviteCode() {
		return inviteCode;
	}

	public void setInviteCode(String inviteCode) {
		this.inviteCode = inviteCode;
	}

	public String getApnsToken() {
		return apnsToken;
	}

	public void setApnsToken(String apnsToken) {
		this.apnsToken = apnsToken;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
