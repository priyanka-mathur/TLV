package com.tlvprocessor.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadInput {

	private static final Logger logger = Logger.getLogger(ReadInput.class.getName());
	private final InputStream in;
	private final BufferedReader reader;

	//Default constructor to read from stdin
	public ReadInput() {
		in = System.in;
		reader = new BufferedReader(new InputStreamReader(in));
	}

	//Parameterized constructor to read from other streams
	public ReadInput(InputStream in) {
		this.in = in;
		reader = new BufferedReader(new InputStreamReader(this.in));
	}

	public String readTLVLine() {
		try {
			return reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void close() {
		try {
			reader.close();
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Exception while reading input: ", e);
		}
	}

}
