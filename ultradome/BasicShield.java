package ultradome;

public class BasicShield implements Shield {

	private float reductionFactor;
	
	public BasicShield() {
		this.reductionFactor = 0.9f;
	}
	
	@Override
	public Strike reduceStrike(Strike strike) {
		strike.setDamage(Math.round(strike.damage * this.reductionFactor));
		return strike;
	}
}
