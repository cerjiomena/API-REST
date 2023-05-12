package mx.com.grupoasesores.api.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;


import lombok.extern.slf4j.Slf4j;
import mx.com.grupoasesores.api.ApiRestApplication;



@SpringBootTest(classes = {ApiRestApplication.class})
@Slf4j
public class ArticuloTest {
	
	@Autowired
	private ArticuloRepository articuloRepository;
	
	@Test
	public void debeInsertarArticulo() {
		log.debug("Entrando a insertarArticulo");
		
		Articulo articulo = new Articulo();
		articulo.setDescripcion("prueba desc");
		articulo.setIdProducto("P0002");
		articulo.setModelo("M0002");
		articulo.setNombre("El nombre");
		articulo.setPrecio(new BigDecimal(10.666664f));
		
		articuloRepository.save(articulo);
		
	}
	
	@Test
	public void debeFallarAlTratarDeInsertarIdProducto() {
		
		log.debug("Entrando a debeFallarAlTratarDeInsertarIdProducto");
		

		Articulo articulo = new Articulo();
		articulo.setDescripcion("prueba desc");
		articulo.setIdProducto("P0001");
		articulo.setModelo("M0002");
		articulo.setNombre("El nombre");
		articulo.setPrecio(new BigDecimal(10.666664f));
		
		articuloRepository.save(articulo);
		
		assertThrows(DataIntegrityViolationException.class, () -> articuloRepository.save(articulo), "Id de producto repetido");
		
	}
	
	

}
