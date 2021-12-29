package enums;

public enum Description {
	LOW("Низкое"), LONG("Длинное"), SMALL("Маленькое"), 
	TINY("Крошечное"), STRANGE("Странное");
	
	 private final String state;

	 Description(String state) {
		 this.state = state;
	 }
	 
	 public String getState() {
		return state;
	}
}
