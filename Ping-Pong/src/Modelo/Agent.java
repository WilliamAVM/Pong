package Modelo;

import net.sourceforge.jFuzzyLogic.*;
import net.sourceforge.jFuzzyLogic.fcl.FclParser.function_block_return;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class Agent {
	private FIS fis;
	private FunctionBlock fb;
	

	public Agent() {
		init();
		fb = fis.getFunctionBlock(null);
	}
	private void init(){

		String fileName = "player2.fcl";
		fis = FIS.load(fileName, true);
		if (fis == null) {
			System.out.println("ERROR AL CARGAR ");
			//return;
		}
	}
	
	public void percibirPelota(int x, int y) {
		System.out.println(x + " , " + y);
	}
	
	public void input(double valorX, double valorY) {
		fb.setVariable("pelotaX", valorX);
		fb.setVariable("pelotaY", valorY);
	}


	public double output() {
		
		fb.evaluate();

		// Show output variable's chart
		fb.getVariable("mov").defuzzify();

		// Print ruleSet
		//System.out.println(fb);
		System.out.println("mov: " + fb.getVariable("mov").getValue());
    return  fb.getVariable("mov").getValue();
	}
}
