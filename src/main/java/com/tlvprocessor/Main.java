package com.tlvprocessor;

import com.tlvprocessor.util.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

  private static final Logger logger = Logger.getLogger(Main.class.getName());

  public static void main(String[] args) {

    String line, str, processedValue;
    ReadInput reader = null;
    WriteOutput writer = null;
    try {
      reader = new ReadInput();
      writer = new WriteOutput();

      while ((line = reader.readTLVLine()) != null && (line.length() != 0)) {
        //extract TLV string from each input line, process it and print it
        while (true) {
          str = Utils.splitString(line);
          processedValue = Utils.processTLV(str);
          writer.writeTLVLine(processedValue);

          if (str.length() != line.length()) {
            line = line.substring(str.length());
          } else {
            break;
          }
        }
      }
    } catch (Exception e) {
      logger.log(Level.SEVERE, "Exception while TLV processing: ", e);
    } finally {
      if (reader != null) reader.close();
      if (writer != null) writer.close();
    }
  }
}
