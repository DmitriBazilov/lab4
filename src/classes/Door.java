package classes;

import java.util.Objects;

public class Door extends Entity {
	private boolean isOpen = false;
	private Place nextPlace;
	private Key needKey;

	public Door() {}
	
	public Door(String name, Place location) {
		super(name, location);
	}
	
	public Door(String name, Place firstLoc, Place secondLoc) {
		super(name, firstLoc);
		this.nextPlace = secondLoc;
	}

	public Door(String name, Place location, boolean isOpen) {
		super(name, location);
		this.isOpen = isOpen;
	}

	public Door(String name, Place firstLoc, Place secondLoc, boolean isOpen) {
		super(name, firstLoc);
		this.isOpen = isOpen;
		this.nextPlace = secondLoc;
	}

	public Door(String name, Place firstLoc, Key needKey) {
		this(name, firstLoc);
		this.needKey = needKey;
	}

	public void setStatusOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	
	public void setNeedKey(Key key) {
		this.needKey = key;
	}

	public void setNextPlace(Place place) {
		this.nextPlace = place;
	}

	public boolean getStatusOpen() {
		return isOpen;
	}

	public Key getNeedKey() {
		return needKey;
	}

	public Place getNextPlace() {
		return nextPlace;
	}
	
	@Override
	public String toString() {
		return getClass().getName() + " name: " + getName() + " location: " + getLocation() 
				+ " isOpen " + isOpen + " description: " + getStringDescription();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getName(), isOpen, getLocation(), getDescription());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Door objDoor = (Door) obj;
		return getName().equals(objDoor.getName()) 
				&& isOpen == objDoor.isOpen
				&& getLocation().equals(objDoor.getLocation())
				&& getDescription().equals(objDoor.getDescription());
	}
	
}
