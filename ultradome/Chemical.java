package ultradome;

public class Chemical extends Strike {
	public Chemical() {
		this.description = new String("Chemical Strike");
		this.damage = 30;
	}
	
	public String getDescription() {
		return this.description;
	}
}
