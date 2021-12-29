package classes;

import java.util.Objects;

public class Door extends Entity {
	private boolean isOpen = false;
	private static final Key NEEDKEY = new Key("Нужный ключ");
	
	public static class CheckerKey {
		public static void tryOpenDoor(Door door, Key key) {
			if (key == NEEDKEY) {
				door.setStatusOpen(true);
				System.out.print(door.getName() + " открылась ");
			} else {
				System.out.print(door.getName() + " не открылась ");
			}
		}
		
		public static boolean isNeedKey(Key key) {
			return (NEEDKEY == key);
		}
	}
	
	public Door() {}
	
	public Door(String name, Place location) {
		super(name, location);
	}
	
	public Door(String name, Place location, boolean isOpen) {
		super(name, location);
		this.isOpen = isOpen;
	}
	
	public void setStatusOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	
	public boolean getStatusOpen() {
		return isOpen;
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
