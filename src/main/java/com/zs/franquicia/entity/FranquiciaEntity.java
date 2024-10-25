package com.zs.franquicia.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "DTQ_FRANQUICIA")
public class FranquiciaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 100)
	private String nombre;	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "franquiciaEntity", fetch = FetchType.LAZY)
	private List<SucursalEntity> lstSucursal;

	public FranquiciaEntity(String nombre) {
		super();
		this.nombre = nombre;
	}

	public FranquiciaEntity(Long id) {
		super();
		this.id = id;
	}
	
	
}
