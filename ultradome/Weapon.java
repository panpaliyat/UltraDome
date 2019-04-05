package ultradome;

abstract public class Weapon {
	
	protected String description;
	protected int maxDamage;
	protected Gladiator owner;
	
	abstract public Strike makeStrike();

	public Gladiator getOwner() {
		return owner;
	}

	public void setOwner(Gladiator owner) {
		this.owner = owner;
	}
}
