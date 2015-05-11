package behaviour;

import jade.core.behaviours.Behaviour;
import agent.HarborAgent;

@SuppressWarnings("serial")
public class HarborRunningBehaviour extends Behaviour{
	private HarborAgent agent;
	private boolean fini;
	public HarborRunningBehaviour(HarborAgent ag){
		agent =  ag;
		fini = false;
	}
	@Override
	public void action() {
		block(5000);
		agent.createBarqueAgent(agent.getResource());
		agent.afficheLife();
		agent.afficheResource();
		if (agent.getResource()== 0){
			System.out.println("Fin");
			fini = true;
		}
		
	}
	@Override
	public boolean done() {

		return fini;
	}

}
