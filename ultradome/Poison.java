package ultradome;

public class Poison extends Weapon {

	@Override
	public Strike makeStrike() {
		Chemical strike = new Chemical();
		int ownersHealth = this.getOwner().getHealth();
		if (ownersHealth < this.maxDamage) {
			strike.setDamage((int)Math.round(Math.random() * ownersHealth));
		} else {
			strike.setDamage((int)Math.round(Math.random() * this.maxDamage));
		}
		//System.out.println(this.description+" produced "+strike.description+" with damage as : "+strike.damage);
		return strike;
	}
	
	public Poison() {
		this.description = new String("Poison");
		this.maxDamage = 55;
		this.owner = null;
	}
}
