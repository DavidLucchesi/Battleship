package behaviour;

import jade.core.behaviours.Behaviour;
import agent.BarqueAgent;

@SuppressWarnings("serial")
public class BarqueRunningBehaviour extends Behaviour{
	BarqueAgent agent;
	
	public BarqueRunningBehaviour(BarqueAgent ag){
		agent = ag;
	}

	@Override
	public void action() {
		block(30000);	
		agent.afficheLife();
		agent.afficheAttack();
		
	}

	@Override
	public boolean done() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
