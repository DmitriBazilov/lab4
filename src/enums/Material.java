package enums;

public enum Material {
	GLASS("Стеклянный"), GOLD("Золотой"), IRON("Железный"), WOOD("Деревянный");
	
	private final String state;
	
	Material(String state) {
		this.state = state;
	}
	
	public String getState() {
		return state;
	}
}
