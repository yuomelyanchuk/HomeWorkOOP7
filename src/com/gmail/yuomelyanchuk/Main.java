package com.gmail.yuomelyanchuk;

import java.util.concurrent.Exchanger;

public class Main {

	public static void main(String[] args) {
		Port port = new Port(2);
		
		Ship ship1 = new Ship(10, "ship1");
		Ship ship2 = new Ship(10, "ship2");
		Ship ship3 = new Ship(10, "ship3");
		
		port.addShip(ship1);
		port.addShip(ship2);
		port.addShip(ship3);
		
		port.closePort();
		
		Exchanger<SourceClass> exChanger = new Exchanger<>();
		SourceClass sc1 = new SourceClass("D://corses//test1//Java OOP (All cource).pdf","D://corses//test2//Java OOP (All cource).pdf");
		SourceClass sc2 = new SourceClass("D://corses//test1//Java OOP (All cource).pdf","D://corses//test2//Java OOP (All cource).pdf");
		new Thread(new Reader(sc1, exChanger)).start();
		new Thread(new Writer(sc2, exChanger)).start();
		

	}

}
