package mx.com.grupoasesores.api.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import mx.com.grupoasesores.api.domain.Articulo;
import mx.com.grupoasesores.api.dto.ArticuloDTO;
import mx.com.grupoasesores.api.error.AplicacionExcepcion;
import mx.com.grupoasesores.api.service.ArticuloService;
import mx.com.grupoasesores.api.util.Constantes;

@RestController
@RequestMapping(path = "/api/v1/articulo")
@Slf4j
public class ArticuloRestController {

	@Autowired
	private ArticuloService articuloService;

	@Autowired
	private MessageSource messageSource;

	@GetMapping(value = "listar", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Servicio web para obtener el listado de articulos")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = -200, message = "Error of communication") })
	public ResponseEntity<Map<String, Object>> obtenerListadoArticulos() {

		if (log.isDebugEnabled())
			log.debug(">> Entrando a ArticuloRestController.obtenerListadoArticulos << ");

		List<ArticuloDTO> listado = null;

		Map<String, Object> response = new HashMap<>();

		response.put(Constantes.TIMESTAMP, new Timestamp(System.currentTimeMillis()));

		listado = articuloService.obtenerArticulos();
		response.put(Constantes.STATUS, HttpStatus.OK.value());
		response.put(Constantes.ARTICULOS, listado);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(value = "obtenerArticulo", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Servicio web para obtener el detalle del articulo")
	public ResponseEntity<Map<String, Object>> obtenerDetalleArticulo(HttpServletRequest request,
			@ApiParam(value = "id_articulo", required = true, example = "P0001") @RequestParam("id_articulo") Optional<String> id) {

		if (log.isDebugEnabled())
			log.debug(">> Entrando a ArticuloRestController.obtenerDetalleArticulo << ");

		Map<String, Object> response = new HashMap<>();

		response.put(Constantes.TIMESTAMP, new Timestamp(System.currentTimeMillis()));

		ArticuloDTO articulo = articuloService.consultarArticulo(id.get());
		response.put(Constantes.STATUS, HttpStatus.OK.value());
		response.put(Constantes.DETAIL_ARTICULO, articulo);

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@PostMapping(value = "actualizarArticulo", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Actualizacion del articulo")
	public ResponseEntity<Map<String, Object>> getObtenerCorreoYEnviarMail(
			@ApiParam(value = "id_articulo", required = true, example = "P0001") @RequestParam(value = "id_articulo") String id,
			@ApiParam(value = "descripcion", required = true, example = "Descripcion a actualizar") @RequestParam(value = "descripcion") String descripcion,
			@ApiParam(value = "modelo", required = true, example = "Modelo a actualizar") @RequestParam(value = "descripcion") String modelo) {

		Map<String, Object> response = new HashMap<>();
		String mensaje = null;

		response.put(Constantes.TIMESTAMP, new Timestamp(System.currentTimeMillis()));

		try {

			Articulo articulo = articuloService.actualizarArticulo(id, descripcion, modelo);
			response.put(Constantes.DETAIL_ARTICULO, articulo);

		} catch (AplicacionExcepcion e) {

			mensaje = e.getMessage();

			response.put(Constantes.MESSAGE, mensaje);
			response.put(Constantes.STATUS, Constantes.ERROR_VALIDATION);
		}

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

}
