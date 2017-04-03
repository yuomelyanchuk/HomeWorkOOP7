package com.gmail.yuomelyanchuk;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Exchanger;

public class Reader implements Runnable {
	private SourceClass sc;
	private Exchanger<SourceClass> exChanger;

	public Reader(SourceClass sc, Exchanger<SourceClass> exChanger) {
		super();
		this.sc = sc;
		this.exChanger = exChanger;

	}

	private void reader() {
		try (InputStream is = new FileInputStream(sc.getSource())) {
			byte[] buffer = new byte[1024];
			int len;
			for (; (len = is.read(buffer)) > 0;) {
				try {
					sc.setBuffer(buffer);
					sc.setLen(len);
					System.out.println(len);
					sc = exChanger.exchange(sc);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
			sc.setAllBytes(true);
			sc.setLen(0);
			try {
				sc = exChanger.exchange(sc);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		reader();

	}

}
