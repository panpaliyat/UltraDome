package agency;

abstract public class Agent extends Thread {
	
	private static Integer nextID = 500;
	
	protected int idNum;
	protected Boolean dead;
	protected Agent partner;
	
	protected Facilitator facilitator;
	
	abstract public void update();
	
	public Agent() {
		super();
		dead = false;
		partner = null;
		idNum = nextID++;
	}
	
	
	public void run() {
		while(!this.dead && !facilitator.halt()) {
			update();
			yield();
		}
	}

	public int getIdNum() {
		return idNum;
	}

	public Boolean getDead() {
		return dead;
	}

	public void setDead(Boolean dead) {
		this.dead = dead;
	}
	
	public Agent getPartner() {
		return partner;
	}

	public void setPartner(Agent partner) {
		this.partner = partner;
	}

	public Facilitator getFacilitator() {
		return facilitator;
	}

	public void setFacilitator(Facilitator facilitator) {
		this.facilitator = facilitator;
	}
}
