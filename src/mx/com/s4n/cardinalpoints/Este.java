package mx.com.s4n.cardinalpoints;

public class Este implements CardinalPoint {

	@Override
	public CardinalPoint derecha() {
		return new Sur();
	}

	@Override
	public CardinalPoint izquierda() {
		return new Norte();
	}

	@Override
	public Move delante() {
		return new Move(1, 0);
	}

	@Override
	public String toString() {
		return "Este";
	}
	
	

}
