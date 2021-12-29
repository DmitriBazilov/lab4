package exceptions;

public class NegativeLightPower extends Exception {
	public NegativeLightPower() {}

	public NegativeLightPower(String message) {
		super(message);
	}
}
