package mx.com.grupoasesores.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.com.grupoasesores.api.domain.Articulo;
import mx.com.grupoasesores.api.domain.ArticuloRepository;
import mx.com.grupoasesores.api.dto.ArticuloDTO;
import mx.com.grupoasesores.api.error.AplicacionExcepcion;
import mx.com.grupoasesores.api.service.ArticuloService;
import mx.com.grupoasesores.api.service.MapStructMapper;
import mx.com.grupoasesores.api.util.MensajeError;


@Service
@Slf4j
public class ArticuloServiceImpl implements ArticuloService {

	@Autowired
	private ArticuloRepository articuloRepository;
	
	@Autowired
	private MapStructMapper mapstructMapper;

	/**
	 * {@link ArticuloService#obtenerArticulos()}
	 */
	public List<ArticuloDTO> obtenerArticulos() {
		
		List<Articulo> listado =  (List<Articulo>)articuloRepository.findAll();
		
		return mapstructMapper.articulosToArticuloAllDtos(listado);
	}

	@Override
	public Articulo actualizarArticulo(String id, String descripcion, String modelo) throws AplicacionExcepcion{

		Articulo articulo = articuloRepository.findByIdProducto(id);
		if(articulo != null) {
			
			articulo.setDescripcion(descripcion);
			articulo.setModelo(modelo);
		
			  try {
				  articulo = articuloRepository.save(articulo);
		        } catch (Exception e) {
		            log.error(e.getMessage());
		            throw new AplicacionExcepcion(MensajeError.ERROR_ACTURALIZAR_ARTICULO);
		        }
			
			
		}
		
		return articulo;
	}

	@Override
	public ArticuloDTO consultarArticulo(String id) {

		Articulo articulo = articuloRepository.findByIdProducto(id);
				
		return mapstructMapper.articuloToArticuloAllDto(articulo);
	}

}
