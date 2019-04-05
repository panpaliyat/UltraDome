package ultradome;

public class IronSkin extends ShieldSkin {

	public IronSkin() {
		this.reductionFactor = 0.3f;
		this.description = new String("Iron Skin");
	}

	public Strike reduceStrike(Strike s) {
		
		if (s instanceof Iron) {
			s.setDamage(Math.round(s.damage * reductionFactor));
		} 
		return super.reduceStrike(s);
	}
}
