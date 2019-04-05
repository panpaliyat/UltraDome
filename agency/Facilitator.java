package agency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

abstract public class Facilitator {

	protected List<Agent> agents = new ArrayList<Agent>();
	private Random gen = new Random(System.nanoTime());

	public int getRandomInt(int bound) {
		return gen.nextInt(bound);
	}

	public abstract Agent makeAgent();

	public void setPartner(Agent a) {
		boolean flag = false;
		int partnerId = this.getRandomInt(this.agents.size() - 1);

		int count = this.agents.size();
		while (count != 0) {
			flag = false;
			Agent partner = this.agents.get(partnerId);

			if (!partner.getDead() && partner.getPartner() == null && partner.getIdNum() != a.getIdNum()) {
				a.setPartner(partner);
				partner.setPartner(a);
				flag = true;
				break;
			}
			count--;
			partnerId += 1;
			if (partnerId > this.agents.size() - 1)
				partnerId = 0;
		}

		if (!flag) {
			System.out.println("No partner is available right now");
		}
	}

	public Boolean halt() {

		int livingCount = 0;
		for (Agent a : agents) {
			if (!a.getDead())
				livingCount++;
		}
		if (livingCount < 2) {
			return true;
		} else
			return false;
	}

	public void start() {
		startSimulation();
		while (!halt()) {
			for (Agent a : agents) {
				if (!a.getDead())
					a.update();
			}
		}
		endSimulation();
	}

	public boolean add(Agent arg0) {
		arg0.setFacilitator(this);
		return agents.add(arg0);
	}

	public Agent get(int arg0) {
		return agents.get(arg0);
	}

	public int size() {
		return agents.size();
	}

	public void startSimulation() {
	}

	public void startIteration() {
	}

	public void endIteration() {
	}

	public void endSimulation() {
	}
}
