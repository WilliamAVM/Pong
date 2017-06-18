package Control;

import Modelo.Agent;
import Modelo.Pelota;

public class ControlAgent {
	
	public static ControlAgent cAgent = new ControlAgent();
	
	public ControlAgent(){
		Agent agent = new Agent();
		Pelota pelota = Pelota.pelota;
		agent.percibirPelota(pelota.x, pelota.y);
		System.out.println("si control agente");
		
	}

}
