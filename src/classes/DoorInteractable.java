package classes;

public interface DoorInteractable {
	public boolean tryOpen(Key key, Door door);

	public void goThrough(Door door);
}
