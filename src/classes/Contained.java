package classes;

public interface Contained<T> {
	void changeLocation(T location);
	
	T getLocation();
}
