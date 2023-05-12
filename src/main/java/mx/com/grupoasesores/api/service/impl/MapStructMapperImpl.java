package mx.com.grupoasesores.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

import mx.com.grupoasesores.api.domain.Articulo;
import mx.com.grupoasesores.api.dto.ArticuloDTO;
import mx.com.grupoasesores.api.service.MapStructMapper;

@Generated(
	    value = "org.mapstruct.ap.MappingProcessor",
	    date = "2021-03-11T19:21:44+0100",
	    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 13.0.2 (Oracle Corporation)"
	)

@Component
public class MapStructMapperImpl implements MapStructMapper {

	
	
	public List<ArticuloDTO> articulosToArticuloAllDtos(List<Articulo> articulos) {

		if(articulos == null) {
			return null;
		}
		
		
		List<ArticuloDTO> list = new ArrayList<ArticuloDTO>(articulos.size());
		
		for (Articulo articulo : articulos) {
			list.add(articuloToArticuloAllDto(articulo));
		}
		
		return list;
	}

	@Override
	public ArticuloDTO articuloToArticuloAllDto(Articulo articulo) {
		
		if(articulo == null) {
			return null;
		}
		
		ArticuloDTO articuloDTO = new ArticuloDTO();
		
		articuloDTO.setId(articulo.getId());
		articuloDTO.setDescripcion(articulo.getDescripcion());
		articuloDTO.setIdProducto(articulo.getIdProducto());
		articuloDTO.setModelo(articulo.getModelo());
		articuloDTO.setNombre(articulo.getNombre());
		articuloDTO.setPrecio(articulo.getPrecio());
		

		return articuloDTO;
	}

	@Override
	public Articulo articuloDTOToArticulo(ArticuloDTO articuloDTO) {
		
		if(articuloDTO == null) {
			return null;
		}
		
		Articulo articulo = new Articulo();
		
		articulo.setId(articuloDTO.getId());
		articulo.setDescripcion(articuloDTO.getDescripcion());
		articulo.setIdProducto(articuloDTO.getIdProducto());
		articulo.setModelo(articuloDTO.getModelo());
		articulo.setNombre(articuloDTO.getNombre());
		articulo.setPrecio(articuloDTO.getPrecio());
		
		
		return articulo;
	}

}
