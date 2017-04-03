package com.gmail.yuomelyanchuk;

public class Ship {
	private int holdSize;
	private String name;

	public Ship(int holdSize,String name) {
		super();
		this.holdSize = holdSize;
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public Ship() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getHoldSize() {
		return holdSize;
	}

	public void setHoldSize(int holdSize) {
		this.holdSize = holdSize;
	}

	public boolean isEmpty() {
		if (holdSize == 0) {
			return true;
		}
		return false;
	}

	public boolean isFull() {
		if (holdSize == 10) {
			return true;
		}
		return false;
	}
	public void add—argo(){
		holdSize+=1;
	}
	public void del—argo(){
		holdSize-=1;
	}

	@Override
	public String toString() {
		return "Ship [holdSize=" + holdSize + "]";
	}

}
