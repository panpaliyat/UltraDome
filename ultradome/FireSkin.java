package ultradome;

public class FireSkin extends ShieldSkin {

	public FireSkin() {
		this.reductionFactor = 0.3f;
		this.description = new String("Fire Skin");
	}
	
	public Strike reduceStrike(Strike s) {
		
		if (s instanceof Fire) {
			s.setDamage(Math.round(s.damage * this.reductionFactor));
		}
		return super.reduceStrike(s);
	}
	
	
}
