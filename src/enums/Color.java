package enums;

public enum Color {
	WHITE("Белый"), BLACK("Чёрный"), RED("Красный"), BLUE("Синий"), GREEN("Зеленый");
	
	 private final String state;

	 Color(String state) {
		 this.state = state;
	 }
	 
	 public String getState() {
		return state;
	}
}
