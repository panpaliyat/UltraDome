package ultradome;

import agency.Agent;

public class Gladiator extends Agent {
	
	private int health = 100;
	private String name;
	
	private Weapon weapon;
	private Shield shield;
	
	public Gladiator(String name) {
		this.name = name;
		this.shield = new BasicShield(); // Default shield is basic shield
		this.weapon = new Sword(); // Default weapon is Sword
		this.weapon.setOwner(this);
	}
	
	@Override
	public void update() {
		UltraDome ud = (UltraDome) this.facilitator;
		int luck = facilitator.getRandomInt(100);
		//System.out.println(this.getGladiatorName()+"'s luck is : "+luck+"%");
		if (0 <= luck && luck < 10) {
			//get more health
			ud.getHealth(this);
		} else if (10 <= luck && luck < 20) {
			//get a new weapon from the available weapons
			Weapon w = ud.getWeapon();
			if (w != null) {
				this.setWeapon(w);
				w.setOwner(this);
				System.out.println(this.getGladiatorName()+" got a new "+getWeapon().description);
			}
		} else if (20 <= luck && luck <= 30) {
			ShieldSkin ss = ud.getShieldSkin();
			if (ss != null)
				strengthenShield(ss);
		} else {
			// find a partner to fight with
			System.out.println(this.getGladiatorName()+" is looking for a partner to fight");
			if (null == getPartner())
				ud.setPartner(this);
			attack();
		}
	}
	
	public void defend(Strike strike) {
		System.out.println(this.getGladiatorName() + " is defending with health "+this.getHealth());
		Strike s = this.shield.reduceStrike(strike);
		this.setHealth(getHealth() - s.damage);
		if (this.getHealth() <= 0) {
			this.setDead(true);
			System.out.println(this.getGladiatorName()+" has died.");
		} else {
			System.out.println(this.getGladiatorName()+"'s new health is "+getHealth());
		}
	}
	
	public void strengthenShield(ShieldSkin ss) {
		ss.setPeer(this.shield);
		this.setShield(ss);
		System.out.println(this.getGladiatorName()+" got a new "+ss.description);
	}
	
	public void attack() {
		if (getPartner() != null) {
			Gladiator opponent = (Gladiator) getPartner();
			System.out.println(this.getGladiatorName() +" is attacking "+opponent.getGladiatorName()+" with "+this.getWeapon().description);
			opponent.defend(getWeapon().makeStrike());
			this.setPartner(null);
			opponent.setPartner(null);
		}
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public String getGladiatorName() {
		return name;
	}

	public void setGladiatorName(String name) {
		this.name = name;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public Shield getShield() {
		return shield;
	}

	public void setShield(Shield shield) {
		this.shield = shield;
	}
}
