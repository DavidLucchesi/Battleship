package agent;

import jade.core.Agent;

@SuppressWarnings("serial")
public abstract class ShipAgent extends Agent{
	private int life;
	private int attack;
	public int getLife(){
		return life;
	}
	public int getAttack(){
		return attack;
	}
	public void setLife(int vie){
		life = vie;
	}
	public void setAttack(int attaque){
		attack=attaque;
	}
	public void afficheLife(){
		System.out.println(getName() + " has " + getLife() + " lifepoints.");
	}
	public void afficheAttack(){
		System.out.println(getName() + " has " + getAttack() + " attackpoints.");
	}
}
