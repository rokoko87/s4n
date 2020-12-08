package mx.com.s4n.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * Instruction enum
 * @author alvazquez
 *
 */
public enum Instruccion {
	
	ADELANTE,
	IZQUIERA,
	DERECHA;
	
	/**
	 * Decode an string of movements
	 * @param cadena string of movements
	 * @return List of Instructions
	 * @throws Exception
	 */
	public static List<Instruccion> decode (String cadena) throws Exception {
		List<Instruccion> instrucciones = null;
		if (cadena != null && cadena.length() > 0) {
			instrucciones = new ArrayList<Instruccion>();
			for (int i=0; i< cadena.length(); i++) {
				char c = cadena.charAt(i);
				if (c == 'I') {
					instrucciones.add(IZQUIERA);
				} else if (c == 'D') {
					instrucciones.add(DERECHA);
				} else if (c == 'A') {
					instrucciones.add(ADELANTE);
				} else {
					throw new Exception("Instruction not recognized");
				}
			}
		}
		return instrucciones;
	}

}
