package com.tlvprocessor.util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WriteOutput {

  private static final Logger logger = Logger.getLogger(WriteOutput.class.getName());
  private final OutputStream out;
  private final BufferedWriter writer;

  //Default constructor to read from stdin
  public WriteOutput() {
    out = System.out;
    writer = new BufferedWriter(new OutputStreamWriter(out));
  }

  //Parameterized constructor to read from other streams
  public WriteOutput(OutputStream out) {
    this.out = out;
    writer = new BufferedWriter(new OutputStreamWriter(this.out));
  }

  public void writeTLVLine(final String s) {
    try {
      writer.write(s);
      writer.newLine();
      writer.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void close() {
    try {
      writer.close();
    } catch (IOException e) {
      logger.log(Level.SEVERE, "Exception while writing output: ", e);
    }
  }

}
