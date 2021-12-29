package classes;

public interface Containable<T> {
	public void addObj(T Obj);
	
	public void delObj(T Obj);
	
	public String getContainerName();
	
	public void outputContainer();
}
