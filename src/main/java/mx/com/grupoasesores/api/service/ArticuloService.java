package mx.com.grupoasesores.api.service;

import java.util.List;

import mx.com.grupoasesores.api.domain.Articulo;
import mx.com.grupoasesores.api.dto.ArticuloDTO;
import mx.com.grupoasesores.api.error.AplicacionExcepcion;

/**
 * Interface para definir la firma de los metodos
 * @author Sergio
 *
 */
public interface ArticuloService {
	
	List<ArticuloDTO> obtenerArticulos();
	
	Articulo actualizarArticulo(String id, String descripcion, String modelo) throws AplicacionExcepcion;
	
	ArticuloDTO consultarArticulo(String id);

}
