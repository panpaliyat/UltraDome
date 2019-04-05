package ultradome;

public class Iron extends Strike {
	public Iron() {
		this.description = new String("Iron Strike");
		this.damage = 25;
	}
	
	public String getDescription() {
		return this.description;
	}
}
