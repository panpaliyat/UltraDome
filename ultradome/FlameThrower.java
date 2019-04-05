package ultradome;

public class FlameThrower extends Weapon{

	@Override
	public Strike makeStrike() {
		Fire strike = new Fire();
		int ownersHealth = this.getOwner().getHealth();
		if (ownersHealth < this.maxDamage) {
			strike.setDamage((int)Math.round(Math.random()*ownersHealth));
		} else {
			strike.setDamage((int)Math.round(Math.random()*this.maxDamage));
		}
		//System.out.println(this.description+" produced "+strike.description+" with damage as : "+strike.damage);
		return strike;
	}

	public FlameThrower() {
		this.description = new String("FlameThrower");
		this.maxDamage = 50;
		this.owner = null;
	}
}
