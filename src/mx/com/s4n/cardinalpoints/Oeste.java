package mx.com.s4n.cardinalpoints;

public class Oeste implements CardinalPoint {

	@Override
	public CardinalPoint derecha() {
		return new Norte();
	}

	@Override
	public CardinalPoint izquierda() {
		return new Sur();
	}

	@Override
	public Move delante() {
		return new Move(-1, 0);
	}
	
	@Override
	public String toString() {
		return "Oeste";
	}

}
