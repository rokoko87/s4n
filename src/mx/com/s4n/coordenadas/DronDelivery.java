package mx.com.s4n.coordenadas;

import java.util.List;

import mx.com.s4n.cardinalpoints.CardinalPoint;
import mx.com.s4n.cardinalpoints.Move;
import mx.com.s4n.enums.Instruccion;

/**
 * Class that represent the travel of a dron
 * @author alvazquez
 *
 */
public class DronDelivery {
	
	/**
	 * Initial position
	 */
	private DronPosition initialPosition;
	
	/**
	 * Instructions to follow
	 */
	private String instructions;
	
	
	
	/**
	 * Initialice a DronDelivery
	 * @param initialPosition  Initial position
	 * @param instructions Instructions to follow
	 */
	public DronDelivery(DronPosition initialPosition, String instructions) {
		super();
		this.initialPosition = initialPosition;
		this.instructions = instructions;
	}


	/**
	 * Complete the route following the instructions
	 * @return the end positon
	 * @throws Exception 
	 */
	public DronPosition delivery () throws Exception {
		List<Instruccion> instrucciones = Instruccion.decode(instructions);
		for (Instruccion instruccion : instrucciones) {
			CardinalPoint current = initialPosition.getCardinalPoint();
			switch (instruccion) {
			case ADELANTE:
				Move cuantoAvanzar = current.delante();
				initialPosition.avanzar(cuantoAvanzar.getX(), cuantoAvanzar.getY());
				break;
			case DERECHA:
				initialPosition.setCardinalPoint(current.derecha());
				break;
			case IZQUIERA:
				initialPosition.setCardinalPoint(current.izquierda());
				break;
			}
		}
		
		return initialPosition;
	}

}
