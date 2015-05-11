package main;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;

public class HarborA {
	public static String SECONDARY_PROPERTIES_FILE = "properties/second.properties";
	public static void main(String[] args) {
		Runtime rt = Runtime.instance();
		ProfileImpl p = null;
		try {
			p = new ProfileImpl(SECONDARY_PROPERTIES_FILE);
			ContainerController cc = rt.createAgentContainer(p);
			AgentController ac = cc.createNewAgent("RedHarbor", "agent.HarborAgent", null);
			ac.start();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
