package classes;

import enums.Mood;

public abstract class Character extends Entity implements Moveable{
	private Mood moodState;
	
	public Character() {}
	
	public Character(String name) {
		super(name);
	}
	
	public Character(String name, Place location) {
		super(name, location);
	}
	
	public Character(String name, Place location, Mood moodstate) {
		super(name, location);
		this.moodState = moodstate;
	}
	
	public void setMoodstate(Mood moodState) {
		if (moodState == null)
			throw new IllegalArgumentException("Null это не настроение");
		this.moodState = moodState;
	}
	
	public Mood getMoodstate() {
		return moodState;
	}
	
	public void moodStateInfo() {
		System.out.print("Настроение у " + getName() + " - " + moodState.getState() + " ");
	}
	
	@Override
	public void getAround() {
		System.out.print(getName() + " Обошёл " + getLocation().getName() + " ");
	}
	
	@Override
	public void moveThere() {
		System.out.print(getName() + " Ходит туда сюда ");
	}
	
	@Override
	public void bangAgainst(Entity entity) {
		System.out.print(getName() + " Наткнулась на " + entity.getName() + " ");
	}
	
}
