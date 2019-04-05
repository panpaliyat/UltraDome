package ultradome;

public class Wand extends Weapon {

	@Override
	public Strike makeStrike() {
		Magic strike = new Magic();
		int ownersHealth = this.getOwner().getHealth();
		if (ownersHealth < this.maxDamage) {
			//Owner has less health than the max damage of the weapons
			strike.setDamage((int)Math.round(Math.random() * ownersHealth));
		} else {
			strike.setDamage((int)Math.round(Math.random() * this.maxDamage));
		}
		return strike;
	}

	public Wand() {
		this.description = new String("Wand");
		this.owner = null;
		this.maxDamage = 50;
	}
}
