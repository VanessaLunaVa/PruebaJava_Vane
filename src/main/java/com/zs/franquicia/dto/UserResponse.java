package com.zs.franquicia.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@lombok.Getter
@lombok.Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
	
	private String id;
	private Date created;
	private Date modified;
	private Date lastLogin;
	private String token;
	private String isActive;

}
