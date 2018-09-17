package com.uxpsystems.assignment.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.ColumnDefault;

@javax.persistence.Entity
@Table(name = "User", schema = "public")
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   @Column(name = "ID", unique = true, nullable = false, updatable= false)
	   private Integer userId;
	
	@Column(name = "username", unique = true, nullable = false)
	  private String username;
	
	@Column(name = "password", nullable = false)
	  private String password;
	
	@Column(name = "status", nullable = false )
	  private String status = "Activated";
	
	
		public Integer getUserId() {
			return userId;
		}
		public void setUserId(Integer userId) {
			this.userId = userId;
		}
	  public String getUsername() {
	  return username;
	  }
	  public void setUsername(String username) {
	  this.username = username;
	  }
	  public String getPassword() {
	  return password;
	  }
	  public void setPassword(String password) {
	  this.password = password;
	  }
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	}
