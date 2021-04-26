package com.qbo.model.security;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario {
	
	@Id
	private Long idusuario;
	private String nomusuario;
	private String cargousuario;
	
	
	


	public String getCargousuario() {
		return cargousuario;
	}
	public void setCargousuario(String cargousuario) {
		this.cargousuario = cargousuario;
	}
	public Long getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
	}
	public String getNomusuario() {
		return nomusuario;
	}
	public void setNomusuario(String nomusuario) {
		this.nomusuario = nomusuario;
	}
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
