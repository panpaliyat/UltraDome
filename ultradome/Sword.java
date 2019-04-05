package ultradome;

public class Sword extends Weapon {

	@Override
	public Strike makeStrike() {
		Iron strike = new Iron();
		int ownersHealth = this.getOwner().getHealth();
		if (ownersHealth < this.maxDamage) {
			strike.setDamage((int)Math.round(Math.random() * ownersHealth));
		} else {
			strike.setDamage((int)Math.round(Math.random() * this.maxDamage));
		}
		//System.out.println(this.description+" produced "+strike.description+" with damage as : "+strike.damage);
		return strike;
	}

	public Sword() {
		this.description = new String("Sword");
		this.owner = null;
		this.maxDamage = 40;
	}
}
