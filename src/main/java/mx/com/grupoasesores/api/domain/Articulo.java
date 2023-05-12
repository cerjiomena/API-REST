package mx.com.grupoasesores.api.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class Articulo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(insertable = true, updatable = false, length = 10, unique = true)
	@Size(max = 10)
	private String idProducto;
	
	@Column(insertable = true, updatable = false, length = 20)
	@Size(max = 20)
	private String nombre;
	
	@Column(insertable = true, updatable = true, length = 200)
	@Size(max = 200)
	private String descripcion;
	
	@Column(insertable = true, updatable = false, precision = 10, scale = 2)
	private BigDecimal precio;
	
	@Column(insertable = true, updatable = true, length = 10)
	@Size(max = 10)
	private String modelo;
	
	

}
