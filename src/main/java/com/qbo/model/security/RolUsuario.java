package com.qbo.model.security;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RolUsuario {

	@Id
	private Long idrol;
	private String nomrol;
	public Long getIdrol() {
		return idrol;
	}
	public void setIdrol(Long idrol) {
		this.idrol = idrol;
	}
	public String getNomrol() {
		return nomrol;
	}
	public void setNomrol(String nomrol) {
		this.nomrol = nomrol;
	}
	public RolUsuario(Long idrol, String nomrol) {
		super();
		this.idrol = idrol;
		this.nomrol = nomrol;
	}
	public RolUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
