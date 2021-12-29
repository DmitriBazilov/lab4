package classes;

import exceptions.NegativeLightPower;

public interface Illuminable {
	public void setPower(int power) throws NegativeLightPower;
	
	public int getPower();
}
