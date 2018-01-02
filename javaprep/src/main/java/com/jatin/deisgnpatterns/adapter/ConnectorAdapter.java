package com.jatin.deisgnpatterns.adapter;


/**
 * Adapter - Extends the socket, takes a plug - make sense, doesn't it?
 * @author sharmaj
 *
 */

public class ConnectorAdapter extends Socket15AMP{
	Plug5AMP plug5AMP;

	public ConnectorAdapter(Plug5AMP plug) {
		this.plug5AMP = plug;
	}

	public static void main(String[] args) {
		// Giving away input to the Plug
		ConnectorAdapter adapter = new ConnectorAdapter(new Plug5AMP());
		
		String inputToPlug = adapter.giveOutput();
		
		System.out.println("New output by adapter is: " + inputToPlug);
	}

	@Override
	public String giveOutput() {
		String outputFrom15AMPSocket = super.giveOutput();
		
		return convert15AMPTo5AMP(outputFrom15AMPSocket);
	}
	
	private String convert15AMPTo5AMP(String outputFromScoket) {
		// TODO: Do some processing
		
		// eventually return 5AMP
		return plug5AMP.getInputForPlug();
	
	}
}
