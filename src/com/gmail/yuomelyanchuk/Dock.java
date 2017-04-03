package com.gmail.yuomelyanchuk;

import java.util.concurrent.Callable;

public class Dock implements Callable<Boolean> {
	private Ship ship;

	public Dock(Ship ship) {
		super();
		this.ship = ship;
	}
	
	private void unload(){
		for ( ; !ship.isEmpty() ; ) {
			System.out.println(ship.getName()+" "+ship.getHoldSize()+" left");
			ship.del—argo();			
			try{
			Thread.sleep(500);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
	}

	@Override
	public Boolean call() throws Exception {
		unload();
		return (new Boolean(true)) ;
	}
	

}
