package agent;

import behaviour.HarborRunningBehaviour;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.wrapper.AgentController;

@SuppressWarnings("serial")
public class HarborAgent extends Agent{
	private int life;
	private int resource;
	private int nbAgents;
	public HarborAgent(){
		life = 1000;
		resource = 500;
		nbAgents = 0;
	}
	public int getLife(){
		return life;
	}
	public int getResource(){
		return resource;
	}
	public int setLife(int vie){
		if (vie>0){
			life=vie;
			return 1;}
		else{
			System.out.println("Plus de vie.");
			vie=0;
			return 0;
		}

	}
	public int setResource(int ressources){
		if (ressources >= 0){
			resource=ressources;
			return 1;}
		else{
			System.out.println("Pas assez de ressources.");
			return 0;
		}
	}
	public void afficheLife(){
		System.out.println(getName() + " has " + getLife() + " lifepoints.");
	}
	public void afficheResource(){
		System.out.println(getName() + " has " + getResource() + " resources.");
	}

	public void createBarqueAgent(int resource){
		String name = "RedBarque";
		if (resource >=100){
			try {
				nbAgents++;
				name = name + nbAgents;
				AgentController acHarbor = getContainerController().createNewAgent(name, "agent.BarqueAgent", null);
				acHarbor.start();
				

			}
			catch(Exception ex){
				ex.printStackTrace();

			}
			setResource(resource-100);
		}
		else 
			System.out.println("Erreur, pas assez de ressources.");

	}


	protected void setup(){
		DFAgentDescription dfad = new DFAgentDescription();
		dfad.setName(getAID());
		ServiceDescription sd = new ServiceDescription();
		sd.setType("Harbor");
		sd.setName(getName());
		dfad.addServices(sd);
		try {
			DFService.register(this, dfad);
		}
		catch (FIPAException fe) {
			fe.printStackTrace();
		}
		System.out.println(getName() + " is operational");
		afficheLife();
		afficheResource();
		System.out.println("HarborRunningBehaviour");
		addBehaviour(new HarborRunningBehaviour(this));
	}

}
