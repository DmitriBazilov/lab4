package main;

import classes.Door;
import classes.Human;
import classes.Illuminable;
import classes.Key;
import classes.Place;
import classes.Rabbit;
import classes.Curtain;
import classes.Table;
import enums.Color;
import enums.Description;
import enums.Material;
import exceptions.NegativeLightPower;
import classes.Character;

public class Main {
	public static void main(String[] args) {
		Place dungeon = new Place("Подземелье");
		dungeon.addDescription(Description.LOW);
		dungeon.addDescription(Description.LONG);
		Human alice = new Human("Алиса", Character.Mood.PANIC);
		Rabbit whiteRabbit = new Rabbit("Кролик");
		whiteRabbit.setColor(Color.WHITE);
		Curtain curtain = new Curtain("Штора", dungeon);
		curtain.addDescription(Description.LONG);

		Door[] doors = new Door[5];
		for (int i = 0; i < doors.length; i++) {
			Key keyForDoor = new Key("Ключ для двери №" + Integer.toString(i) + " ");
			doors[i] = new Door("Дверь" + Integer.toString(i), dungeon, keyForDoor);
		}
		
		Table table = new Table("Столик", dungeon, Material.GLASS);
		table.addDescription(Description.SMALL);
		Key key = new Key("Ключик");
		key.setMaterial(Material.GOLD);
		table.addObj(key);
		
		//Анонимный класс
		for (int i = 0; i < 8; i++) {
			Illuminable lamp = new Illuminable() {
				int power = 30;
				
				@Override
				public void setPower(int power) throws NegativeLightPower {
					if (power < 0) {
						throw new NegativeLightPower();
					}
					this.power = power;
				}
				
				@Override
				public int getPower() {
					return power;
				}
			};
			dungeon.addLamp(lamp);
		}
		
		alice.moodStateInfo();
		whiteRabbit.changeLocation(null);
		alice.changeLocation(dungeon);
		dungeon.outputDescription();
		dungeon.printIlluminaton();
		alice.getAround();
		alice.countOpenDoors(doors);
		alice.getAround();
		alice.countOpenDoors(doors);
		alice.setMoodstate(Character.Mood.DEPRESSION);
		alice.moodStateInfo();
		alice.moveThere();
		alice.bangAgainst(table);
		table.outputDescription();
		table.infoMaterial();
		table.outputContainer();
		alice.setMoodstate(Character.Mood.GLAD);
		for (int i = 0; i < doors.length; i++) {
			alice.tryOpen(key, doors[i]);
		}
		alice.bangAgainst(curtain);
		
	}
}
