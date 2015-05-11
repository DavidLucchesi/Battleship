package agent;

import behaviour.BarqueRunningBehaviour;

@SuppressWarnings("serial")
public class BarqueAgent extends ShipAgent{
	public BarqueAgent(){
		setLife(100);
		setAttack(20);
	}
	protected void setup(){
		System.out.println(getName() + " is operational");
		System.out.println("BarqueRunningBehaviour");
		addBehaviour(new BarqueRunningBehaviour(this));
	}
}
