package classes;

import java.util.ArrayList;
import java.util.Objects;

import enums.Material;

public class Table extends Entity implements Containable<Entity>{
	private ArrayList<Entity> container = new ArrayList<>();
	private Material material;
	
	public Table() {}
	
	public Table(String name) {
		 super(name);
	}
	
	public Table(String name, Place location) {
		super(name, location);
	}
	
	public Table(String name, Place location, Material material) {
		this(name, location);
		this.material = material;
	}
	
	public void setMaterial(Material material) {
		if (material == null) {
			throw new IllegalArgumentException("null это не материал");
		}
		this.material = material;
	}
	
	public Material getMaterial() {
		return material;
	}
	
	public void infoMaterial() {
		System.out.print(material.getState() + " ");
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
		return getName();
	}

	@Override
	public void outputContainer() {
		System.out.print("В " + this.getContainerName() + " находится: ");
		for (Entity entity : container) {
			entity.outputDescription();
			System.out.print(entity.getName() + " ");
		}
	}
	
	@Override
	public String toString() {
		return getClass().getName() + " name: " + getName() + " material " + material.getState()
				+ " location: " + getLocation() + " description: " + getStringDescription();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getName(), material.getState(), getLocation(), getDescription());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Table objTable = (Table) obj;
		return getName().equals(objTable.getName()) 
				&& material.equals(objTable.material)
				&& getLocation().equals(objTable.getLocation())
				&& getDescription().equals(objTable.getDescription());
	}
	
}




