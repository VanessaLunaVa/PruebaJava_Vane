package com.zs.franquicia.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "DTQ_SUCURSAL")
public class SucursalEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 100)
	private String nombre;	
	
	@ManyToOne
    @JoinColumn(name = "ID_FRANQUICIA")
	private FranquiciaEntity franquiciaEntity;

	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "sucursalEntity")
	private List<ProductoEntity> lstProductos;

	public SucursalEntity(Long id) {
		this.id = id;
	}
	
}
