package mx.com.s4n.dron;

import mx.com.s4n.cardinalpoints.CardinalPoint;
import mx.com.s4n.cardinalpoints.Norte;

/**
 * A dron position
 * @author alvazquez
 *
 */
public class DronPosition {

	private static final Integer MAX_POSITION_X_Y = 10;

	/**
	 * The x axis
	 */
	private int x;

	/**
	 * The y axis
	 */
	private int y;

	/**
	 * The Cardinal Point [N,S,E,O]
	 */
	private CardinalPoint cardinalPoint;

	/**
	 * Create a Drop Position
	 * @param x
	 * @param y
	 * @param cardinalPoint (N,S,E,O)
	 */
	public DronPosition(int x, int y, CardinalPoint cardinalPoint) {
		super();
		this.x = x;
		this.y = y;
		this.cardinalPoint = cardinalPoint;
	}

	/**
	 * Default position to start the route
	 * @return Positio (0,0,N)
	 */
	public static DronPosition stepCero () {
		return new DronPosition(0,0,new Norte());
	}

	/**
	 * How many go in the X axis and Y axis
	 * @param avanzarX
	 * @param avanzarY
	 * @throws Exception
	 */
	public void avanzar (int avanzarX, int avanzarY) throws Exception {
		this.x += + avanzarX;
		this.y += + avanzarY;

		if (this.x > MAX_POSITION_X_Y)
			throw new Exception("The max X axis is " + MAX_POSITION_X_Y);

		if (this.y > MAX_POSITION_X_Y)
			throw new Exception("The max Y axis is " + MAX_POSITION_X_Y);
	}


	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public CardinalPoint getCardinalPoint() {
		return cardinalPoint;
	}
	public void setCardinalPoint(CardinalPoint cardinalPoint) {
		this.cardinalPoint = cardinalPoint;
	}


	/**
	 * Text to describe de Drop position
	 * Format: (x,y) direccion CardinalPoint[N,S,E,O]
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		sb.append(this.x);
		sb.append(",");
		sb.append(this.y);
		sb.append(") dirección ");
		sb.append(this.cardinalPoint.toString());
		return sb.toString();
	}


}
