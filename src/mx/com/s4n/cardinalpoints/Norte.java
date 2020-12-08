package mx.com.s4n.cardinalpoints;

public class Norte implements CardinalPoint {

	@Override
	public CardinalPoint derecha() {
		return new Este();
	}

	@Override
	public CardinalPoint izquierda() {
		return new Oeste();
	}

	@Override
	public Move delante() {
		return new Move(0, 1);
	}

	@Override
	public String toString() {
		return "Norte";
	}
	
}
