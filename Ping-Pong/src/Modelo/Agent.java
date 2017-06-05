package Modelo;


import net.sourceforge.jFuzzyLogic.*;

public class Agent {
	private FIS fis;

	public Agent(){
		String fileName = "player.fcl";
		fis = FIS.load(fileName,true);
	}
	
	public void input(double valorX,double valorY){
		fis.setVariable("pelotaX", valorX);
		fis.setVariable("pelotaY", valorY);
	}
	
	public void run(){
		fis.evaluate();
	}
	
	public void output(){

		fis.getVariable("movimiento").getLatestDefuzzifiedValue();
		fis.getVariable("movimiento").chartDefuzzifier(true);

        System.out.println(fis);
	}
}
