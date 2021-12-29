package classes;

public class Curtain extends Entity {
	private int transperense;

	public Curtain(String name) {
		super(name);
	}
	
	public Curtain(String name, int transperense) {
		super(name);
		this.transperense = transperense;
	}
	
	public Curtain(String name, Place location) {
		super(name, location);
		this.transperense = transperense;
	}
}
