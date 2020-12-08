package mx.com.s4n.cardinalpoints;

public class Sur implements CardinalPoint {

	@Override
	public CardinalPoint derecha() {
		return new Oeste();
	}

	@Override
	public CardinalPoint izquierda() {
		return new Este();
	}

	@Override
	public Move delante() {
		return new Move(0, -1);
	}
	
	@Override
	public String toString() {
		return "Sur";
	}

}
