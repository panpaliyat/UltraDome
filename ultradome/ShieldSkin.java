package ultradome;

public class ShieldSkin implements Shield {

	protected Shield peer;
	protected float reductionFactor;
	protected String description;

	public ShieldSkin() {
		peer = null;
	}
	
	@Override
	public Strike reduceStrike(Strike strike) {
		return peer.reduceStrike(strike);
	}

	public void setPeer(Shield peer) {
		this.peer = peer;
	}
}
