package classes;

import java.util.Objects;
import enums.Color;

public class Human extends Character implements DoorInteractable {
	private String gender;
	
	//Вложенный нон-статик класс
	public class Eye {
		private Color color;
		
		public void setColor(Color color) {
			if (color == null) {
				throw new IllegalArgumentException("Null это не цвет");
			}
			this.color = color;
		}
		
		public Color getColor() {
			return color;
		}
		
		public void lookAt(Entity e) {
			if (e == null) {
				throw new IllegalArgumentException("Не на что смотреть");
			}
			System.out.print(getName() + " на " + e.getName() + " ");
		}
	}
	
	public Human() {}
	
	public Human(String name) {
		super(name);
	}
	
	public Human(String name, Place location) {
		super(name, location);
	}
	
	public Human(String name, Mood moodstate) {
		super(name);
		this.setMoodstate(moodstate);
	}
	
	public Human(String name, Place location, Mood moodState) {
		super(name, location, moodState);
	}
	
	public Human(String name, Place location, String gender) {
		this(name, location);
		this.gender = gender;
	}
	
	public Human(String name, Place location, Mood moodstate, String gender) {
		this(name, location, moodstate);
		this.gender = gender;
	}
	
	public void setGender(String gender) {
		if (gender == null) {
			throw new IllegalArgumentException("Null это не гендер");
		}
		this.gender = gender;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void countOpenDoors(Door[] doors) {
		int count = 0;
		for (Door d : doors) {
			if (d.getStatusOpen()) {
				count++;
			}
		}
		if (count == 0) {
			System.out.print("Все двери закрыты ");
		} else {
			System.out.print(count + " дверей открыто ");
		}
		
	}
	
	@Override 
	public boolean tryOpen(Key key, Door door) {
		System.out.print(getName() + " пытается открыть " + door.getName() + " ");

		if (door.getStatusOpen()) {
			System.out.print(door.getName() + " и так была открыта ");
			return true;
		}
		
		if (key.equals(door.getNeedKey())) {
			door.setStatusOpen(true);
			System.out.print("У " + getName() + " получилось! "); 
			return true;
		} else {
			System.out.print("У " + getName() + " не получилось( "); 
			return false;
		}
	}	
	
	@Override
	public void goThrough(Door door) {
		this.changeLocation(door.getNextPlace());
	}

	@Override
	public String toString() {
		return getClass().getName() + " name: " + getName() + " gender: " + gender
				+ " mood: " + getMoodstate().getState() + " location: " + getLocation()
				+ " description: " + getStringDescription();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getName(), gender, getMoodstate(), getLocation(), getDescription());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Human objHuman = (Human) obj;
		return getName().equals(objHuman.getName()) 
				&& gender.equals(objHuman.gender)
				&& getMoodstate().equals(objHuman.getMoodstate()) 
				&& getLocation().equals(objHuman.getLocation())
				&& getDescription().equals(objHuman.getDescription());
	}
	
	
}
