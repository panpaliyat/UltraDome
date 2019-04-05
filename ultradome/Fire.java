package ultradome;

public class Fire extends Strike {
	public Fire() {
		this.description = new String("Fire Strike");
		this.damage = 60;
	}
	
	public String getDescription() {
		return this.description;
	}
}
