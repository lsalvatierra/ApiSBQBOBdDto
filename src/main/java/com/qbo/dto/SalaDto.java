package com.qbo.dto;



public class SalaDto implements DtoEntity {

	private Long idsala;	
	private String descsala;
	private Integer asientos;
	private EstadoDto estado;
	
	
	public SalaDto(Long idsala, String descsala, Integer asientos, EstadoDto estado) {
		super();
		this.idsala = idsala;
		this.descsala = descsala;
		this.asientos = asientos;
		this.estado = estado;
	}
	public EstadoDto getEstado() {
		return estado;
	}
	public void setEstado(EstadoDto estado) {
		this.estado = estado;
	}
	public Long getIdsala() {
		return idsala;
	}
	public void setIdsala(Long idsala) {
		this.idsala = idsala;
	}
	public String getDescsala() {
		return descsala;
	}
	public void setDescsala(String descsala) {
		this.descsala = descsala;
	}
	public Integer getAsientos() {
		return asientos;
	}
	public void setAsientos(Integer asientos) {
		this.asientos = asientos;
	}
	public SalaDto(Long idsala, String descsala, Integer asientos) {
		super();
		this.idsala = idsala;
		this.descsala = descsala;
		this.asientos = asientos;
	}
	public SalaDto() {

	}
	
	
}
