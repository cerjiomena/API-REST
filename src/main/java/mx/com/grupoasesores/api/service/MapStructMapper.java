package mx.com.grupoasesores.api.service;

import java.util.List;

import org.mapstruct.Mapper;

import mx.com.grupoasesores.api.domain.Articulo;
import mx.com.grupoasesores.api.dto.ArticuloDTO;

@Mapper(
	    componentModel = "spring"
	)
public interface MapStructMapper {

	 List<ArticuloDTO> articulosToArticuloAllDtos(List<Articulo> articulos);
	 
	 ArticuloDTO articuloToArticuloAllDto(Articulo articulo);
	 
	 Articulo articuloDTOToArticulo(ArticuloDTO articuloDTO);
}
