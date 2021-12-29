package classes;

import java.util.Objects;

import enums.Material;

public class Key extends Entity {
	private Material material;
	
	public Key() {}

	public Key(String name) {
		super(name);
	}
	
	public Key(String name, Place location) {
		super(name, location);
	}
	
	public Key(String name, Place location, Material material) {
		this(name, location);
		this.material = material;
	}
	
	public void setMaterial(Material material) {
		if (material == null) {
			throw new IllegalArgumentException("Null это не материал");
		}
		this.material = material;
	}
	
	public Material getMaterial() {
		return material;
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
		Key objKey = (Key) obj;
		return getName().equals(objKey.getName()) 
				&& material.equals(objKey.material)
				&& getLocation().equals(objKey.getLocation())
				&& getDescription().equals(objKey.getDescription());
	}
	
}
