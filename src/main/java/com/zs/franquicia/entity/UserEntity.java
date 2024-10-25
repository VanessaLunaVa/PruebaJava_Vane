package com.zs.franquicia.entity;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@lombok.Getter
@lombok.Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "DTQ_USUARIO")
public class UserEntity implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String uuid;

	@Column(length = 250)
	private String name;
	
	@Column(name = "email", length = 250)
	private String username;

	@Column(length = 60)
	private String password;
	
	@Column
	private Date created;
	
	@Column
	private Date modified;
	
	@Column(name = "last_login")
	private Date lastLogin;

	@Column(length = 250)
	private String token;

	@Column(length = 200)
	private String isactive;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Transient
	private Long expirationTime;
}