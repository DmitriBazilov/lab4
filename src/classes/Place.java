package classes;

import java.util.ArrayList;
import enums.Description;
import exceptions.InvalidNameException;

public class Place implements Containable<Entity>{
	private String name;
	private ArrayList<Description> description = new ArrayList<>();
	private ArrayList<Entity> container = new ArrayList<>();
	private ArrayList<Illuminable> lights = new ArrayList<>();
	
	public Place() {
		this.name = "Place";
	}
	
	public Place(String name) {
		if (name == null || name.isEmpty()) {
			throw new InvalidNameException("Некорректное имя");
		}
		this.name = name;
	}
	
	public void setName(String name) {
		if (name == null || name.isEmpty()) {
			throw new InvalidNameException("Некорректное имя");
		}
		this.name = name;
	}
	
	public void addDescription(Description description) {
		if (description == null) {
			throw new IllegalArgumentException("Null это не описание");
		}
		this.description.add(description);
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Description> getDescription() {
		return description;
	}
	
	public void outputDescription() {
		for (Description d : description) {
			System.out.print(d.getState() + " ");
		}
	}
	
	public void addLamp(Illuminable light) {
		if (light == null) {
			throw new IllegalArgumentException("null это не источник света");
		}
		lights.add(light);
	}
	
	public double getIllumination() {
		//Локальный класс
		class Calculation {
			private double result;
			
			public Calculation(ArrayList<Illuminable> lights) {
				for (Illuminable light : lights) {
					result += light.getPower();
				}
				
				result /= lights.size();
			}
			
			public double getResult() {
				return result;
			}
		}
		Calculation calculation = new Calculation(lights);
		return calculation.getResult();
	}
	
	public void printIlluminaton() {
		double iLevel = getIllumination();
		if (iLevel < 20) {
			System.out.print("темно ");
		} else if (iLevel < 40) {
			System.out.print("темновато ");
		} else if (iLevel < 60) {
			System.out.print("норм по свету ");
		} else if (iLevel < 80) {
			System.out.print("светло");
		} else {
			System.out.print("очень светло ");
		}
	}
	
	@Override
	public void addObj(Entity Obj) {
		if (Obj == null) {
			throw new IllegalArgumentException("null это не сущность");
		}
		container.add(Obj);
	}
	
	@Override
	public void delObj(Entity Obj) {
		container.remove(Obj);
	}
	
	@Override
	public String getContainerName() {
		return name;
	}
	
	@Override
	public void outputContainer() {
		System.out.print("В " + this.getContainerName() + " находится: ");
		for (Entity entity : container) {
			entity.outputDescription();
			System.out.print(entity.getName() + " ");
		}
	}
	
}
