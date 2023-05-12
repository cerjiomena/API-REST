package mx.com.grupoasesores.api.util;

public enum MensajeError {
	
	ERROR_TIEMPO_ESPERA_OPERACION("error.timeout"),
	ERROR_NO_INFO_DETALLE("error.data.detail"),
	ERROR_NO_INFO_DESCRIPCIONES("error.data.descriptions"),
	ERROR_NO_INFO_EVOLUCIONES("error.data.evolutions"),
	ERROR_NO_INFO_LISTADO("error.data.list"),
	ERROR_ACTURALIZAR_ARTICULO("error.update.item");
	
	private String llaveMensaje;
	
	private MensajeError(String llaveMensaje) {
		this.llaveMensaje= llaveMensaje;
	}
	
	public String getLLaveMensaje() {
		return llaveMensaje;
	}

	
	
}
