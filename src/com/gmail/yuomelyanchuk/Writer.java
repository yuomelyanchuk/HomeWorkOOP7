package com.gmail.yuomelyanchuk;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.Exchanger;

public class Writer implements Runnable {
	private SourceClass sc;
	private Exchanger<SourceClass> exChanger;

	public Writer(SourceClass sc, Exchanger<SourceClass> exChanger) {
		super();
		this.sc = sc;
		this.exChanger = exChanger;
	}

	private void writer() {
		try (OutputStream os = new FileOutputStream(sc.getDest())) {
			try {
				sc = exChanger.exchange(sc);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			for (; sc.getLen() > 0;) {
				try {
					System.out.println(sc.getLen());
					os.write(sc.getBuffer(), 0, sc.getLen());
					sc = exChanger.exchange(sc);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		writer();

	}

}
