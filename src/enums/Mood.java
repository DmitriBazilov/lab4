package enums;

public enum Mood {
	DEPRESSION("Уныние"), GLAD("Радость"), PANIC("Паника");
	
	private final String state;
	
	Mood(String state) {
		this.state = state;
	}		
	
	public String getState() {
		return state;
	}
}
