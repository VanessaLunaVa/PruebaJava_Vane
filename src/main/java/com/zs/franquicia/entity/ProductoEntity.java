package com.zs.franquicia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@lombok.Getter
@lombok.Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "DTQ_PRODUCTO")
public class ProductoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 100)
	private String nombre;	
	
	@Column
	private Long cantidad;
	
	@ManyToOne
    @JoinColumn(name = "ID_SUCURSAL")
	private SucursalEntity sucursalEntity;

	public ProductoEntity(String nombre, Long cantidad) {
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
	}
	
	
}