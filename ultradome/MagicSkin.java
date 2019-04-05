package ultradome;

public class MagicSkin extends ShieldSkin {

	public MagicSkin() {
		this.reductionFactor = 0.2f;
		this.description = new String("Magic Skin");
	}
	
	public Strike reduceStrike(Strike s) {
		if (s instanceof Magic) {
			s.setDamage(Math.round(s.damage * this.reductionFactor));
		}
		return super.reduceStrike(s);
	}
}
