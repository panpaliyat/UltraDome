package ultradome;

public class ChemicalSkin extends ShieldSkin {

	public ChemicalSkin() {
		this.reductionFactor = 0.2f;
		this.description = new String("Chemical skin");
	}
	
	public Strike reduceStrike(Strike s) {
		
		if (s instanceof Chemical) {
			s.setDamage(Math.round(s.damage * this.reductionFactor));
		}
		return super.reduceStrike(s);
	}
}
