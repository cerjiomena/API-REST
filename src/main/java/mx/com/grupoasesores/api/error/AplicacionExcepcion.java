package mx.com.grupoasesores.api.error;

import mx.com.grupoasesores.api.util.MensajeError;

public class AplicacionExcepcion extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  MensajeError codigoError = null;
	
	public AplicacionExcepcion(String msj) {
		super(msj);
	}
	
	public AplicacionExcepcion(MensajeError codigoError) {
		this.codigoError = codigoError;
	}
	
	public MensajeError getCodigoError() {
		return codigoError;
	}

}

