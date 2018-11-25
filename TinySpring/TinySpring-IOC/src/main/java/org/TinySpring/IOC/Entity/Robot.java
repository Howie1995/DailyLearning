package org.TinySpring.IOC.Entity;

public class Robot {

	private Hand hand;
	
	private Mouth mouth;
	
	public void show(){
		hand.waveHand();
		mouth.speak();
	}
	
}
