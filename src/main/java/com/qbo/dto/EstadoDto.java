package com.qbo.dto;

public class EstadoDto implements DtoEntity {

    private String descestado;

	public String getDescestado() {
		return descestado;
	}

	public void setDescestado(String descestado) {
		this.descestado = descestado;
	}

	public EstadoDto(String descestado) {
		super();
		this.descestado = descestado;
	}

	public EstadoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
