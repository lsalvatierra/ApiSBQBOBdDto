package com.qbo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="asiento")
public class Asiento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long idasiento;	
	
	@Column(name = "nroasiento")
	private Integer nroasiento;

	public Long getIdasiento() {
		return idasiento;
	}

	public void setIdasiento(Long idasiento) {
		this.idasiento = idasiento;
	}

	public Integer getNroasiento() {
		return nroasiento;
	}

	public void setNroasiento(Integer nroasiento) {
		this.nroasiento = nroasiento;
	}

	public Asiento(Long idasiento, Integer nroasiento) {
		super();
		this.idasiento = idasiento;
		this.nroasiento = nroasiento;
	}

	public Asiento() {

	}

	//Cuando una entidad es persistida, su entidad relacionada 
	//debe ser persistida también.
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idsala")
	private Sala sala;

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Asiento(Long idasiento, Integer nroasiento, Sala sala) {
		super();
		this.idasiento = idasiento;
		this.nroasiento = nroasiento;
		this.sala = sala;
	}
	

}
