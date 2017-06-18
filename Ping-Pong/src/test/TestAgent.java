package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Modelo.Agent;

public class TestAgent {

	@Test
	public void test() {
		
		Agent agent = new Agent();
		agent.input(50, 50);
		agent.output();
	}

}
