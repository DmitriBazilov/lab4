package classes;

import java.util.ArrayList;

import enums.Description;
import exceptions.*;

public abstract class Entity implements Contained<Place> {
	private String name;
	private ArrayList<Description> description = new ArrayList<>();
	private Place location;
	
	public Entity() {}
	
	public Entity(String name) {
		if (name == null || name.isEmpty()) {
			throw new InvalidNameException("Некорректное имя");
		}
		this.name = name;
	}
	
	public Entity(String name, Place location) {
		this(name);
		this.location = location;
	}
	
	public void setName(String name) {
		if (name == null || name.isEmpty()) {
			throw new InvalidNameException("Некорректное имя");
		}
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void infoLocation() {
		System.out.print(name + " в " + location.getName());
	}
	
	public void addDescription(Description description) {
		if (description == null) {
			throw new IllegalArgumentException("Null это не описание"); 
		}
		this.description.add(description);
	}
	
	public ArrayList<Description> getDescription() {
		return description;
	}
	
	public String getStringDescription() {
		String result = "";
		for (Description d : description) {
			result += d.getState() + " ";
		}
		return result;
	}
	
	public void outputDescription() {
		for (Description d : description) {
			System.out.print(d.getState() + " ");
		}
	}
	
	@Override
	public void changeLocation(Place location) {
		if (location == null) {
			System.out.print(name + " исчез ");
			this.location = null;
		} else {
			System.out.print(name + " переместился в " + location.getName() + " ");
			this.location = location;
		}	
	}
	@Override
	public Place getLocation() {
		return location;
	}
	
}
