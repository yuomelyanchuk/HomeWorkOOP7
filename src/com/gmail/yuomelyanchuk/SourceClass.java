package com.gmail.yuomelyanchuk;

import java.io.File;

public class SourceClass {
	private long fileSize = 0;
	private long alreadyCopy = 0;
	private byte[] buffer = new byte[1024];
	private int len;
	private File source;
	private File dest;
	private boolean allBytes=false;

	public SourceClass(String source, String dest) {
		super();
		this.source = new File(source);
		this.dest = new File(dest);
	}

	public File getSource() {
		return source;
	}

	public void setSource(File source) {
		this.source = source;
	}
	

	public boolean isAllBytes() {
		return allBytes;
	}

	public void setAllBytes(boolean allBytes) {
		this.allBytes = allBytes;
	}

	public File getDest() {
		return dest;
	}

	public void setDest(File dest) {
		this.dest = dest;
	}

	public int getLen() {
		return len;
	}

	public void setLen(int len) {
		this.len = len;
	}

	public byte[] getBuffer() {
		return buffer;
	}

	public void setBuffer(byte[] buffer) {
		this.buffer = buffer;
	}

}
