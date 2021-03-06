package com.tlvprocessor;

import com.tlvprocessor.exception.TypeNotValidException;
import com.tlvprocessor.util.TransformerFactory;

public class TLV {

  public static final int lengthStringLength = 4;
  public static final int typeLength = 6;
  public static final int delimiterCount = 2;
  public static final String delimiter = "-";

  private String type;
  private int length;
  private String value;

  /**
   * @param type   defines the type of processing required
   * @param length specifies the length of the value
   * @param value  actual data to be processed of length "length" above
   */
  public TLV(final String type, final int length, final String value) {
    if (value == null || length != value.length()) {
      throw new IllegalArgumentException("length != value.length");
    }

    this.type = type;
    this.length = length;
    this.value = value;
  }

  /**
   * Process value with type
   *
   * @return the string after processing value
   */
  public String processValue() {
    try {
      return TransformerFactory.getProcessor(TypeEnum.getValue(this.type)).transform(this.value);
    } catch (TypeNotValidException e) {
      return e.toString();
    }
  }

  public String getType() {
    return type;
  }

  public void setTag(final String type) {
    this.type = type;
  }

  public int getLength() {
    return length;
  }

  public void setLength(final int length) {
    this.length = length;
  }

  public String getValue() {
    return value;
  }

  public void setValue(final String value) {
    this.value = value;
  }

}
