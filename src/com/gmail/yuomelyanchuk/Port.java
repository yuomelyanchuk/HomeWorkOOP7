package com.gmail.yuomelyanchuk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Port {
	private ExecutorService exSer;

	public Port(int dockCount) {
		super();
		exSer = Executors.newFixedThreadPool(dockCount);

	}

	public void addShip(Ship ship) {
		exSer.submit(new Dock(ship));

	}

	public void closePort() {
		exSer.shutdown();
	}

}
