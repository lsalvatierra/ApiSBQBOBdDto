package com.qbo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="sala")
public class Sala {
	/* Entre la entidad autor y entidad publicación tenemos una 
	 * relación bidireccional, obteniendo una recursividad infinita
	 * para realizar la deserialización utilizamos las anotaciones
	 * @JsonManagedReference = parte directa de la referencia la misma que se serializa
	 *  @JsonBackReference = parte inversa de la referencia y 
	 *  los campos / colecciones marcados con esta anotación no se serializan.
	 * Con estas anotaciones dejamos a Jaskon que maneje la relación
	 * */	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long idsala;	
	
	@Column(name = "descsala")
	private String descsala;
	@Column(name = "asientos")
	private Integer asientos;
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
	
	//Indica que si se elimina el objeto empleado tambien se 
	//elimina el objeto asociado
	@OneToOne(cascade = CascadeType.ALL) 
	@JoinColumn(name = "idestado") //Hace referencia a la columna que es FK
	private Estado estado;
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	//orphanRemoval = true Es una especificación del ORM 
	//nos permite eliminar un elemento de la lista desde una 
	//referencia del objeto principal
	//mappedBy = Hace referencia a la definición del objeto autor en Publicación
	@JsonManagedReference
	@OneToMany(mappedBy = "sala" , cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Asiento> listasiento = new ArrayList<Asiento>();
	public List<Asiento> getListasiento() {
		return listasiento;
	}
	public void setListasiento(List<Asiento> listasiento) {
		this.listasiento = listasiento;
	}


	
}
