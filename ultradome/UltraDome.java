package ultradome;

import java.util.ArrayList;
import java.util.List;

import agency.Agent;
import agency.Facilitator;

public class UltraDome extends Facilitator {
	private int availableMedicine = 500;
	private List<Weapon> weapons = new ArrayList<Weapon>();
	private List<ShieldSkin> skins = new ArrayList<ShieldSkin>();
	
	private UltraDome () {
		addWeapons();
		addShieldSkins();
	}

	@Override
	public Agent makeAgent() {
		return null;
	}
	
	private void addWeapons() {
		for (int i=0;i<13; i++) {
			weapons.add(new Poison());
			weapons.add(new Wand());
			weapons.add(new Sword());
			weapons.add(new FlameThrower());
		}
	}
	
	public void getHealth(Gladiator g) {
		if (availableMedicine < 1) {
			System.out.println("Medicine is over");
			return;
		}
		
		int val = 100 - g.getHealth();
		
		if (val > 0 && availableMedicine >= val) {
			availableMedicine -= val;
			g.setHealth(g.getHealth()+val);
			System.out.println("Restoring "+g.getGladiatorName()+"'s health to 100. Available Medicines: "+availableMedicine);
		}
	}
	
	public Weapon getWeapon() {
		if (weapons.size() > 0) {
			int weaponLoc = this.getRandomInt(weapons.size());
			Weapon w = weapons.get(weaponLoc);
			weapons.remove(w);
			return w;
		} else {
			return null;
		}
	}
	
	public ShieldSkin getShieldSkin() {
		if (skins.size() > 0) {
			int loc = this.getRandomInt(skins.size());
			ShieldSkin skin = skins.get(loc);
			skins.remove(skin);
			return skin;
		} else {
			return null;
		}
	}
	
	private void addShieldSkins() {
		for (int i = 0; i < 13; i++) {
			skins.add(new IronSkin());
			skins.add(new MagicSkin());
			skins.add(new FireSkin());
			skins.add(new ChemicalSkin());
		}
	}
	
	public void startSimulation() {
		System.out.println("UltraDome game has started");
	}
	public void endSimulation() {
		System.out.println("UltraDome game has ended");
	}
		
	public static void main(String[] args) {
		UltraDome ud = new UltraDome();
		
		Gladiator james = new Gladiator("James");
		Gladiator robert = new Gladiator("Robert");
		Gladiator mike = new Gladiator("Mike");
		Gladiator butler = new Gladiator("Butler");
		Gladiator rupert = new Gladiator("Rupert");
		Gladiator romeo = new Gladiator("Romeo");
		Gladiator oscar = new Gladiator("Oscar");
		Gladiator tango = new Gladiator("Tango");
		Gladiator victor = new Gladiator("Victor");
		Gladiator aristotle = new Gladiator("Aristotle");
		Gladiator socrates = new Gladiator("Socrates");
		Gladiator cuthbert = new Gladiator("Cuthbert");
		Gladiator charles = new Gladiator("Charles");
		Gladiator sherlock = new Gladiator("Sherlock");
		Gladiator susan = new Gladiator("Susan");
		Gladiator sarah = new Gladiator("Sarah");
		Gladiator dorothy = new Gladiator("Dorothy");
		Gladiator issac = new Gladiator("Issac");
		Gladiator will = new Gladiator("Will");
		Gladiator light = new Gladiator("Light");

		ud.add(james);
		ud.add(robert);
		ud.add(mike);
		ud.add(butler);
		ud.add(rupert);
		ud.add(romeo);
		ud.add(oscar);
		ud.add(tango);
		ud.add(victor);
		ud.add(aristotle);
		ud.add(socrates);
		ud.add(cuthbert);
		ud.add(charles);
		ud.add(sherlock);
		ud.add(susan);
		ud.add(sarah);
		ud.add(dorothy);
		ud.add(issac);
		ud.add(will);
		ud.add(light);
		
		ud.start();
	}
}
