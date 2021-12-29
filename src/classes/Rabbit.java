package classes;

import java.util.Objects;

import enums.Color;
import enums.Mood;

public class Rabbit extends Character{
	private Color color;
	
	public Rabbit() {}
	
	public Rabbit(String name) {
		super(name);
	}
	
	public Rabbit(String name, Place location) {
		super(name, location);
	}
	
	public Rabbit(String name, Place location, Mood moodstate) {
		super(name, location, moodstate);
	}
	
	public Rabbit(String name, Place location, Color color) {
		this(name, location);
		this.color = color;
	}
	
	public Rabbit(String name, Place location, Mood moodstate, Color color) {
		this(name, location, moodstate);
		this.color = color;
	}
	
	public void setColor(Color color) {
		if (color == null) {
			throw new IllegalArgumentException("null это не цвет");
		}
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}
	
	@Override
	public String toString() {
		return getClass().getName() + " name: " + getName() + " color: " + color.getState()
				+ " mood: " + getMoodstate().getState() + " location: " + getLocation()
				+ " description: " + getStringDescription();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getName(), color, getMoodstate(), getLocation(), getDescription());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rabbit objRabbit = (Rabbit) obj;
		return getName().equals(objRabbit.getName()) 
				&& color.equals(objRabbit.color)
				&& getMoodstate().equals(objRabbit.getMoodstate()) 
				&& getLocation().equals(objRabbit.getLocation())
				&& getDescription().equals(objRabbit.getDescription());
	}
	
}
