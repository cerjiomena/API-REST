package mx.com.grupoasesores.api.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ArticuloDTO {


	private Long id;
	

	private String idProducto;
	

	private String nombre;
	

	private String descripcion;
	
	private BigDecimal precio;
	

	private String modelo;
}
